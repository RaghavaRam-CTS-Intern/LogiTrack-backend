# LogiTrack Backend — IAM + Analytics & Reporting
### Interview Preparation & Reference Guide

> **Your role:** You built the **IAM (Identity & Access Management)** and **Analytics & Reporting** modules of LogiTrack — user management, login with JWT, role-based access control, the system-wide audit trail, the reporting module, and the unit tests (Stories IAM-001 → IAM-006).

**One-line pitch (memorize this):**
> *"I built the security and identity layer of LogiTrack — user management, login with JWT authentication, role-based access control, the system-wide audit trail, and the analytics reporting module — plus the unit tests for it. Every other module depends on mine, because nothing runs without login and everything writes to my audit trail."*

---

## Table of Contents
1. [The Big Picture](#1-the-big-picture)
2. [Technology Stack](#2-technology-stack)
3. [Layered Architecture](#3-layered-architecture-most-important)
4. [Story-by-Story Code Walkthrough](#4-story-by-story-code-walkthrough)
5. [The Request Lifecycle](#5-the-full-request-lifecycle)
6. [Interview Q&A](#6-interview-qa)
7. [Glossary of Terms](#7-glossary)
8. [How to Run & Demo](#8-how-to-run--demo)
9. [Known Limitations / Future Work](#9-known-limitations--future-work)

---

## 1. The Big Picture

**What is LogiTrack?**
A **backend** for a logistics / supply-chain system. A backend has no screens — it's a program running on a server that listens for **HTTP requests**, talks to a **database**, and returns data (usually **JSON**). A separate React frontend (on `localhost:3000`) draws the actual screens.

The app is split into modules. **You owned two:**

| Module | Plain English | Stories |
|---|---|---|
| **IAM** | "Who is allowed in, and what can they do." Accounts, login, passwords, role permissions. | IAM-001 → IAM-004 |
| **Analytics & Reporting** | Audit trail (a log of everything that happens) + management reports built from it. | IAM-005 |
| **Testing** | Automated tests proving the code works. | IAM-006 |

---

## 2. Technology Stack

| Tech | What it is | Why it's here |
|---|---|---|
| **Java** | The programming language. | Everything is written in it. |
| **Spring Boot** | A framework (pre-built toolkit) that runs the app & wires components together. | Runs on **port 8085**. |
| **Maven** | Build tool — downloads libraries, compiles, runs tests. | `mvn test`, `mvn spring-boot:run`. |
| **MySQL** | Relational database — stores data in tables. | DB `logitrack_backend_db`. |
| **JPA / Hibernate** | ORM — translates Java objects ↔ DB tables, writes SQL for you. | So you rarely write SQL by hand. |
| **Lombok** | Removes boilerplate (`@Data`, `@Builder`). | Less repetitive code. |
| **JWT** | "JSON Web Token" — a signed digital ID card issued at login. | Stateless authentication. |
| **BCrypt** | One-way password hashing algorithm. | Passwords never stored in plain text. |
| **JUnit + Mockito** | Testing libraries (JUnit runs tests; Mockito fakes dependencies). | IAM-006 tests. |
| **SLF4J** | Logging (`log.info(...)`). | Auditing/debugging. |
| **AOP** | Aspect-Oriented Programming — runs code "around" other code. | The auto-audit aspect. |

---

## 3. Layered Architecture (MOST IMPORTANT)

Every request flows through the same layers. **Memorize this:**

```
HTTP request (e.g. POST /api/users)
      │
      ▼
[ Controller ]   ← receives web request, returns response   (UserController)
      │
      ▼
[ Service ]      ← business logic & rules                    (UserServiceImpl)
      │
      ▼
[ Repository ]   ← talks to the database                     (UserRepository)
      │
      ▼
[ Database ]     ← MySQL tables
```

Supporting pieces:
- **Entity** — Java class mapped to a DB table (`User`, `AuditLog`, `LogisticsReport`).
- **DTO** (Data Transfer Object) — "safe" version of data sent over the web (`UserDTO` has **no password**).
- **Security filter** — checkpoint that runs *before* the controller to verify the JWT.

**Why separate layers?** Each piece has one job; you can change/test one without breaking others.

**Why both Entity and DTO?**
1. **Security** — `User` entity has `passwordHash`; `UserDTO` does not → the hash never leaks.
2. **Decoupling** — API shape stays stable even if the database changes.

**Why interface + implementation (`UserService` + `UserServiceImpl`)?**
> Programming to an interface — loose coupling, and it makes the service trivial to mock in unit tests.

---

## 4. Story-by-Story Code Walkthrough

### IAM-001 & IAM-002 — Data Model (tables + entities + repositories)

**3 tables**, each represented by an `@Entity` class.

#### `User` — `entity/User.java`
```java
@Entity @Table(name = "users")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;                 // primary key, auto-increment
    private String name;
    @Enumerated(EnumType.STRING) private Role role;   // stored as text "ADMIN"
    @Column(unique = true) private String email;      // no duplicates
    private String phone;
    private Integer hubId;
    private String passwordHash;            // BCrypt hash, NEVER plain text
    @Enumerated(EnumType.STRING) @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;
}
```
**Annotations to explain:**
- `@Entity` → "this class is a DB table."
- `@Id` → primary key. `@GeneratedValue(IDENTITY)` → DB auto-assigns 1,2,3…
- `@Enumerated(EnumType.STRING)` → store role as readable text, not a number (reorder-safe).
- `@Column(unique = true)` → DB enforces unique email.
- `@Builder.Default` → new users default to `ACTIVE`.

**7 roles** (`enums/Role.java`): `SHIPPER, COORDINATOR, WAREHOUSEOPS, DRIVER, COMPLIANCE, ANALYST, ADMIN`.
An **enum** = a fixed list of allowed values.

#### `AuditLog` — `entity/AuditLog.java`  ("who did what, when")
```java
@ManyToOne @JoinColumn(name = "UserID") private User user;  // many logs → one user
@Column(length = 50) private String action;                 // e.g. "USER_CREATED"
private String entityType;                                  // e.g. "User"
@CreationTimestamp private LocalDateTime timestamp;         // auto-set on save
```
- `@ManyToOne` → foreign-key relationship: many audit logs belong to one user.
- `@CreationTimestamp` → Hibernate auto-fills the time on insert.

#### `LogisticsReport` — `entity/LogisticsReport.java`
```java
private String scope;                                    // e.g. "GLOBAL"
@Column(columnDefinition = "TEXT") private String metrics;  // JSON string of numbers
@CreationTimestamp private LocalDateTime generatedDate;
```
`metrics` is a **JSON string in a TEXT column** — flexible storage; change metrics without changing the table.

#### Repositories — database access with (almost) zero SQL
A repository is an interface Spring Data JPA **auto-implements**.

`repository/UserRepository.java`:
```java
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);   // auto → WHERE email = ?
    List<User> findByStatus(UserStatus status);
    boolean existsByEmail(String email);
}
```
- `extends JpaRepository<User, Integer>` → free `save()`, `findById()`, `findAll()`, `delete()`.
- **Derived query**: a method named `findByEmail` → Spring auto-writes the SQL.

`repository/AuditLogRepository.java` — one **custom JPQL query** + **pagination**:
```java
@Query("SELECT a FROM AuditLog a WHERE a.user.userId = :userId")
List<AuditLog> findByUserId(@Param("userId") Integer userId);
Page<AuditLog> findAll(Pageable pageable);   // returns one page at a time
```
**Pagination** = return data in pages (e.g. 20 at a time) instead of thousands at once → performance.

---

### IAM-003 — DTOs, Exceptions, and Service Logic

#### Validation — `dto/RegisterRequestDTO.java`
```java
@NotBlank private String name;
@NotBlank @Email private String email;
@NotBlank private String password;
@NotNull  private Role role;
```
These are **Bean Validation** annotations. With `@Valid` on the controller, Spring rejects bad input **before** your code runs; `GlobalExceptionHandler` turns failures into a clean `400`.

#### Centralized error handling — `exception/GlobalExceptionHandler.java`
`@RestControllerAdvice` applies one error-handling class to **all** controllers:

| You throw | Returns |
|---|---|
| `ResourceNotFoundException` | **404** Not Found |
| `BadRequestException` | **400** Bad Request |
| `MethodArgumentNotValidException` | **400** with field errors |
| any other `Exception` | **500** Internal Server Error |

#### The Service — core business logic — `serviceImplementation/UserServiceImpl.java`

`createUser` step by step:
```java
public UserDTO createUser(RegisterRequestDTO dto) {
    if (userRepository.existsByEmail(dto.getEmail()))            // 1. uniqueness rule
        throw new BadRequestException("Email already exists: " + dto.getEmail());
    User user = User.builder()
        .name(...).email(...).role(...)
        .passwordHash(passwordEncoder.encode(dto.getPassword())) // 2. HASH password
        .status(UserStatus.ACTIVE).build();
    User saved = userRepository.save(user);                      // 3. save to DB
    log.info("User created: {}", saved.getEmail());              // 4. log (SLF4J)
    audit(saved.getUserId(), "USER_CREATED");                    // 5. audit trail
    return toDTO(saved);                                         // 6. return SAFE dto (no password)
}
```
**Key security point (step 2):** `passwordEncoder.encode(...)` runs BCrypt. The plain password is **never** stored — only a one-way hash. A hash can't be reversed back to the password.

`deleteUser` = **soft delete** (don't remove the row):
```java
user.setStatus(UserStatus.INACTIVE);
userRepository.save(user);
```
> *"I implemented soft delete — flip status to INACTIVE instead of deleting. Preserves history, audit trail, and foreign-key integrity."*

**Dependency Injection (DI):** the constructor receives `userRepository`, `passwordEncoder`, `auditLogService`. You never call `new` — Spring creates and injects them (**IoC = Inversion of Control**). This is **constructor injection**.

---

### IAM-004 — REST APIs, Login & JWT Security (the crown jewel)

#### Controllers map URLs → methods — `controller/UserController.java`

| HTTP | URL | Method | Returns |
|---|---|---|---|
| POST | `/api/users` | createUser | 201 Created |
| GET | `/api/users` | getAllUsers | 200 + list |
| GET | `/api/users/{id}` | getUserById | 200 / 404 |
| PATCH | `/api/users/{id}?status=` | updateUserStatus | 200 |
| DELETE | `/api/users/{id}` | deleteUser | 204 No Content |

- `@RestController` → handles web requests, returns JSON.
- `@RequestMapping("/api/users")` → base URL.
- `@PathVariable` → value from the URL (`/users/5` → id=5).
- `@RequestParam` → query parameter (`?status=INACTIVE`).
- `@RequestBody` → JSON body → Java object.
- `ResponseEntity` → control the HTTP status code.

#### Login flow — `controller/AuthController.java` (the most important method)
```java
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {
    Optional<User> userOpt = userRepository.findByEmail(dto.getEmail());
    if (userOpt.isEmpty() ||
        !passwordEncoder.matches(dto.getPassword(), userOpt.get().getPasswordHash()))
        return ResponseEntity.status(UNAUTHORIZED).body(Map.of("error","Invalid credentials")); // 401
    User user = userOpt.get();
    String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());  // make JWT
    LoginResponseDTO response = LoginResponseDTO.builder()
        .token(token).role(...).userId(...).name(...).build();
    auditLogService.logAction(user.getUserId(), "LOGIN", "User");  // audit the login
    return ResponseEntity.ok(response);
}
```
1. Look up user by email.
2. `passwordEncoder.matches(raw, hash)` — BCrypt re-hashes the typed password and compares. **Never decrypt** — hash-and-compare.
3. Wrong → **401 Unauthorized**.
4. Right → generate **JWT**, return it with role/userId/name.

#### What is a JWT? — `security/JwtUtil.java`
A JWT = a **signed, tamper-proof ID card**. `generateToken` puts email (`subject`) + role inside, sets a 24h expiry (`86400000` ms), and signs with a secret using **HS256**:
```java
return Jwts.builder()
    .setSubject(email).claim("role", role)
    .setIssuedAt(now).setExpiration(expiry)
    .signWith(getSigningKey(), SignatureAlgorithm.HS256)
    .compact();
```
Because only the server knows the secret, **nobody can forge or modify it**. Change the role in the token → signature breaks → `validateToken` returns false.

**Why JWT? = STATELESS auth.** The server stores nothing about the session; the token carries identity. Any server can verify it. (Config: `SessionCreationPolicy.STATELESS`.)

#### The security checkpoint — `security/JwtFilter.java`
Runs on **every request before the controller** (`OncePerRequestFilter`):
1. Reads `Authorization: Bearer <token>` header.
2. Validates the token.
3. Extracts email + role and tells Spring Security the user is authenticated:
```java
List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));
UsernamePasswordAuthenticationToken authentication =
    new UsernamePasswordAuthenticationToken(email, null, authorities);
SecurityContextHolder.getContext().setAuthentication(authentication);
```

#### Role-Based Access Control — `config/SecurityConfig.java`
The rulebook of *who can call what* (your module's lines):
```java
.requestMatchers(POST, "/api/auth/login", "/api/auth/register").permitAll()   // public
.requestMatchers("/api/users/**").hasRole("ADMIN")                            // ADMIN only
.requestMatchers(GET, "/api/audit-logs/**").hasAnyRole("ANALYST","ADMIN")
.requestMatchers("/api/logistics-reports/**").hasAnyRole("ANALYST","ADMIN")
.anyRequest().authenticated()                                                 // else: must be logged in
.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);      // plug in the filter
```
Also:
- `.csrf().disable()` — not needed for stateless JWT APIs (no cookies/sessions). Standard for REST.
- `BCryptPasswordEncoder` declared as a `@Bean` → the single shared instance injected everywhere.

---

### IAM-005 — Analytics & Reporting

#### Audit Log APIs — `controller/AuditLogController.java`
- `GET /api/audit-logs` — filters: `?userId=`, `?action=`, `?from=&to=` (date range); else **paginated** all-logs.
- `POST /api/audit-logs` — **internal write hook** other modules call to record actions (that's why it's `permitAll` in SecurityConfig).

`serviceImplementation/AuditLogServiceImpl.java` → `logAction(userId, action, entityType)` is the **shared utility** the whole app uses. Your `UserServiceImpl` calls it on every create/update/delete.

#### Report generation — `serviceImplementation/LogisticsReportServiceImpl.java`
```java
List<AuditLog> logs = auditLogRepository.findByTimestampBetween(from, to);     // 1. pull events
Map<String,Long> countsByAction = logs.stream()
    .collect(Collectors.groupingBy(AuditLog::getAction, Collectors.counting())); // 2. group & count
long shipmentCount = countsByAction.getOrDefault("FREIGHT_ORDER_CREATED",0L)
                   + countsByAction.getOrDefault("SHIPMENT_CREATED",0L);        // 3. derive metric
String metrics = String.format("{\"shipmentCount\":%d, ...}", ...);            // 4. build JSON
reportRepository.save(report);                                                  // 5. persist
```
Step 2 is a **Java Stream** — `groupingBy(action, counting())` is like SQL `GROUP BY action, COUNT(*)`.
**Be honest:** some metrics (onTimeRate 85.5, etc.) are **placeholder values**; only `shipmentCount` and `totalAuditEvents` come from real data.
`getSummary()` returns the **latest** report via `stream().max(comparing(generatedDate))`.

---

### BONUS — Auto-Audit with AOP — `aspect/AuditAspect.java`
**AOP** runs code automatically around other code. This aspect auto-records an audit log for **every** successful POST/PUT/PATCH/DELETE in any controller — without that controller writing audit code:
```java
@AfterReturning("within(...controller..*) "
  + "&& !within(AuthController) && !within(UserController) && !within(AuditLogController)")
public void auditWrite(JoinPoint joinPoint) { ... }
```
- `@AfterReturning` → run after the method succeeds.
- Excludes `AuthController`, `UserController`, `AuditLogController` because they audit themselves with richer names (`LOGIN`, `USER_CREATED`) or *are* the audit hook → avoids duplicate/recursive entries.
- Derives action from HTTP method (POST→CREATE, DELETE→DELETE) and entity from controller name.

> *"Cross-cutting concerns like auditing don't belong scattered in business logic, so I centralized them with an AOP aspect. Modules needing richer semantics opt out and log explicitly."*

---

### IAM-006 — Unit Tests
`test/.../UserServiceTest.java` and `LogisticsReportServiceTest.java`.

A **unit test** checks one class in isolation. The service needs a repository/encoder/audit service — we don't want a real DB — so **Mockito** creates fakes ("mocks") and we tell them how to behave.

```java
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock private UserRepository userRepository;          // fake DB
    @Mock private BCryptPasswordEncoder passwordEncoder;  // fake encoder
    @Mock private AuditLogService auditLogService;        // fake audit
    @InjectMocks private UserServiceImpl userService;     // REAL class, fakes injected
```
- `@Mock` → fake object. `@InjectMocks` → real class under test with mocks injected.
- `when(...).thenReturn(...)` → **stubbing** (define mock behavior).
- `verify(...)` → assert a method was (or wasn't) called.

Duplicate-email test:
```java
when(userRepository.existsByEmail(anyString())).thenReturn(true);  // pretend it exists
assertThrows(BadRequestException.class, () -> userService.createUser(registerRequest));
verify(userRepository, never()).save(any(User.class));             // and we never saved
```
Pattern: **Arrange → Act → Assert**. Run with `mvn test`.

---

## 5. The Full Request Lifecycle

```
Request + JWT
   → JwtFilter      : validate token, extract role, set SecurityContext
   → SecurityConfig : does this role allow this URL?  (else 401/403)
   → Controller     : parse request, call service
   → Service        : business rules (e.g. hash password, uniqueness check)
   → Repository     : save/fetch from MySQL
   → AuditAspect    : after a successful write, record audit log (AOP)
   → Response (JSON, with proper HTTP status)
```

---

## 6. Interview Q&A

**Q: Walk me through a login.**
> POST email+password to `/api/auth/login`. Look up by email; BCrypt `matches()` compares against the stored hash. Invalid → 401. Valid → generate a signed JWT (email + role, 24h expiry), return it with role/userId/name, record a LOGIN audit. Frontend stores the token and sends it on every later request.

**Q: How does authorization work after login?**
> Every request hits `JwtFilter` first: validate signature + expiry, extract role, set it in Spring's SecurityContext. Then `SecurityConfig` checks the URL against role rules (`/api/users/**` → ADMIN; `/api/logistics-reports/**` → ANALYST/ADMIN).

**Q: Why JWT, not sessions?**
> Stateless — server stores nothing; token carries identity and is tamper-proof via the HMAC signature. Scales horizontally; decouples the frontend.

**Q: How are passwords stored?**
> Never plain text. BCrypt one-way hash. Login re-hashes and compares — can't be reversed. BCrypt is salted and deliberately slow → resists brute-force.

**Q: Entity vs DTO?**
> Entity maps to the DB table (has `passwordHash`). DTO crosses the API boundary — `UserDTO` omits the password so it never leaks. Also decouples API shape from schema.

**Q: Authentication vs Authorization?**
> Authentication = who you are (login + JWT). Authorization = what you're allowed to do (role checks).

**Q: Why interface + implementation for services?**
> Programming to an interface — loose coupling and trivial mocking in tests.

**Q: How did you test without a database?**
> Mockito mocks for repository/encoder/audit, `@InjectMocks` for the real service, stub with `when/thenReturn`, assert behavior and `verify` interactions. No DB, no Spring context — fast and isolated.

**Q: What's a soft delete?**
> Flip status to INACTIVE instead of deleting the row — preserves history, audit trail, and referential integrity.

**Q: What is Dependency Injection / IoC?**
> Spring creates objects and supplies their dependencies (via the constructor) instead of you calling `new`. Loose coupling, easy testing.

**Q: What is AOP and where did you use it?**
> Aspect-Oriented Programming runs cross-cutting code around methods. I used `@AfterReturning` to auto-record audit logs for every successful state-changing controller call.

**Q: What would you improve?**
> Compute all report metrics from real data; add refresh tokens + token revocation; add integration tests (`@SpringBootTest`/MockMvc); move the JWT secret to an environment variable instead of `application.yml`.

---

## 7. Glossary

| Term | Meaning |
|---|---|
| **REST API** | A way to expose operations over HTTP using URLs + verbs (GET/POST/PATCH/DELETE). |
| **JSON** | Text data format `{ "key": "value" }` used for requests/responses. |
| **Entity** | Java class mapped to a DB table. |
| **DTO** | Data Transfer Object — safe data shape for the API. |
| **ORM** | Object-Relational Mapping (Hibernate) — Java objects ↔ SQL tables. |
| **JPA** | The Java standard for ORM; Spring Data JPA implements it. |
| **Repository** | Interface for DB access; Spring auto-generates queries from method names. |
| **Derived query** | A query Spring builds from a method name (`findByEmail`). |
| **DI / IoC** | Dependency Injection / Inversion of Control — Spring supplies dependencies. |
| **Bean** | An object Spring creates and manages. |
| **JWT** | Signed token carrying identity; used for stateless auth. |
| **BCrypt** | Slow, salted one-way password hash. |
| **Stateless** | Server keeps no session; each request is self-contained. |
| **RBAC** | Role-Based Access Control — permissions by role. |
| **AOP** | Aspect-Oriented Programming — cross-cutting code around methods. |
| **Mock / Stub** | Fake object / its scripted behavior, used in unit tests. |
| **Pagination** | Returning data in pages instead of all at once. |
| **Soft delete** | Mark a row inactive instead of physically deleting it. |

---

## 8. How to Run & Demo

1. **Start:** `mvn spring-boot:run` → app on **port 8085**, connects to MySQL `logitrack_backend_db`.
2. **Login:** Postman `POST /api/auth/login` with a seeded user (password `password123`) → copy the `token`.
3. **Call protected API:** add header `Authorization: Bearer <token>` → e.g. `GET /api/users` (ADMIN) or `POST /api/logistics-reports` (ANALYST).
4. **Show the trail:** `GET /api/audit-logs` → see your own actions recorded.
5. **Run tests:** `mvn test` → green.

**Config (`application.yml`):** port `8085`, DB `logitrack_backend_db` (root/root), `jwt.expiration` 24h, `ddl-auto: update` (Hibernate auto-creates/updates tables).

---

## 9. Known Limitations / Future Work
*(Mention these to show maturity — "I know the limitations.")*

- **Report metrics** are partly **placeholder** values; only `shipmentCount` / `totalAuditEvents` are real. → Compute all from real data.
- **JWT secret** is hardcoded in `application.yml`. → Externalize to an environment variable / secrets manager.
- **No refresh tokens / revocation.** → Add refresh-token flow and a token blacklist.
- **Unit tests only.** → Add integration tests with `@SpringBootTest` + MockMvc to cover controllers + security.
- **DB credentials** in plain config. → Externalize for production.

---

*Files referenced live under `src/main/java/com/cognizant/logitrack/` (entity, repository, dto, service, serviceImplementation, controller, security, config, aspect, exception, enums) and tests under `src/test/java/com/cognizant/logitrack/`.*

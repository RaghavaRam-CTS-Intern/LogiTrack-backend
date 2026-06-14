package com.cognizant.logitrack.controller;

import com.cognizant.logitrack.dto.LoginRequestDTO;
import com.cognizant.logitrack.dto.LoginResponseDTO;
import com.cognizant.logitrack.dto.RegisterRequestDTO;
import com.cognizant.logitrack.dto.UserDTO;
import com.cognizant.logitrack.entity.User;
import com.cognizant.logitrack.repository.UserRepository;
import com.cognizant.logitrack.service.UserService;
import com.cognizant.logitrack.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody RegisterRequestDTO dto) {
        UserDTO created = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {
        Optional<User> userOpt = userRepository.findByEmail(dto.getEmail());
        if (userOpt.isEmpty() || !passwordEncoder.matches(dto.getPassword(), userOpt.get().getPasswordHash())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid credentials"));
        }
        User user = userOpt.get();
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        LoginResponseDTO response = LoginResponseDTO.builder().token(token).role(user.getRole().name()).userId(user.getUserId()).name(user.getName()).build();
        log.info("User logged in: {}", user.getEmail());
        return ResponseEntity.ok(response);
    }
}

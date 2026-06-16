package com.cognizant.logitrack.config;

import com.cognizant.logitrack.entity.AuditLog;
import com.cognizant.logitrack.entity.User;
import com.cognizant.logitrack.enums.Role;
import com.cognizant.logitrack.enums.UserStatus;
import com.cognizant.logitrack.repository.AuditLogRepository;
import com.cognizant.logitrack.repository.UserRepository;
import com.cognizant.logitrack.entity.Notification;
import com.cognizant.logitrack.enums.NotificationCategory;
import com.cognizant.logitrack.enums.NotificationStatus;
import com.cognizant.logitrack.repository.NotificationRepository;
import com.cognizant.logitrack.entity.Carrier;
import com.cognizant.logitrack.entity.RateCard;
import com.cognizant.logitrack.entity.Route;
import com.cognizant.logitrack.enums.*;
import com.cognizant.logitrack.repository.CarrierRepository;
import com.cognizant.logitrack.repository.RateCardRepository;
import com.cognizant.logitrack.repository.RouteRepository;
import com.cognizant.logitrack.entity.Supplier;
import com.cognizant.logitrack.enums.SupplierStatus;
import com.cognizant.logitrack.repository.SupplierRepository;
import com.cognizant.logitrack.entity.WarehouseInventory;
import com.cognizant.logitrack.repository.WarehouseInventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DataSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final AuditLogRepository auditLogRepository;
    private final CarrierRepository carrierRepository;
    private final RouteRepository routeRepository;
    private final RateCardRepository rateCardRepository;
    private final SupplierRepository supplierRepository;
    private final WarehouseInventoryRepository inventoryRepository;
    private final NotificationRepository notificationRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, AuditLogRepository auditLogRepository, CarrierRepository carrierRepository, RouteRepository routeRepository, RateCardRepository rateCardRepository, SupplierRepository supplierRepository, WarehouseInventoryRepository inventoryRepository, NotificationRepository notificationRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.auditLogRepository = auditLogRepository;
        this.carrierRepository = carrierRepository;
        this.routeRepository = routeRepository;
        this.rateCardRepository = rateCardRepository;
        this.supplierRepository = supplierRepository;
        this.inventoryRepository = inventoryRepository;
        this.notificationRepository = notificationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        seedUsers();
        seedAuditLogs();
        seedCarriers();
        seedRoutes();
        seedRateCards();
        seedSuppliers();
        seedInventory();
        seedNotifications();
        log.info("Data seeding complete.");
    }

    private void seedUsers() {
        if (userRepository.count() != 0) {
            return;
        }
        String hash = passwordEncoder.encode("password123");
        Role[] roles = {Role.SHIPPER, Role.COORDINATOR, Role.WAREHOUSEOPS, Role.DRIVER, Role.COMPLIANCE, Role.ANALYST, Role.ADMIN};
        for (Role role : roles) {
            String emailPrefix = role.name().toLowerCase();
            User user = User.builder().name(role.name() + " User").role(role).email(emailPrefix + "@logitrack.com").phone("9000000000").hubId(1).passwordHash(hash).status(UserStatus.ACTIVE).build();
            userRepository.save(user);
        }
        log.info("Seeded {} users", roles.length);
    }

    private void seedAuditLogs() {
        if (auditLogRepository.count() != 0) {
            return;
        }
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return;
        }
        User u1 = users.get(0);
        User u2 = users.size() > 1 ? users.get(1) : u1;
        List<AuditLog> logs = new ArrayList<>();
        logs.add(AuditLog.builder().user(u1).action("USER_CREATED").entityType("User").build());
        logs.add(AuditLog.builder().user(u1).action("LOGIN").entityType("User").build());
        logs.add(AuditLog.builder().user(u2).action("FREIGHT_ORDER_CREATED").entityType("FreightOrder").build());
        auditLogRepository.saveAll(logs);
        log.info("Seeded {} audit logs", logs.size());
    }

    private void seedCarriers() {
        if (carrierRepository.count() != 0) {
            return;
        }
        carrierRepository.save(Carrier.builder().name("Roadways Express").mode(RouteMode.ROAD).serviceLevel(CarrierServiceLevel.STANDARD).contactDetails("contact@roadways.com").status(CarrierStatus.ACTIVE).build());
        carrierRepository.save(Carrier.builder().name("SkyCargo Air").mode(RouteMode.AIR).serviceLevel(CarrierServiceLevel.EXPRESS).contactDetails("contact@skycargo.com").status(CarrierStatus.ACTIVE).build());
        carrierRepository.save(Carrier.builder().name("OceanLine Shipping").mode(RouteMode.SEA).serviceLevel(CarrierServiceLevel.STANDARD).contactDetails("contact@oceanline.com").status(CarrierStatus.ACTIVE).build());
        log.info("Seeded 3 carriers");
    }

    private void seedRoutes() {
        if (routeRepository.count() != 0) {
            return;
        }
        routeRepository.save(Route.builder().originHubId(1).destinationHubId(2).transitDays(2).mode(RouteMode.ROAD).status(RouteStatus.ACTIVE).build());
        routeRepository.save(Route.builder().originHubId(1).destinationHubId(3).transitDays(1).mode(RouteMode.AIR).status(RouteStatus.ACTIVE).build());
        routeRepository.save(Route.builder().originHubId(2).destinationHubId(4).transitDays(5).mode(RouteMode.SEA).status(RouteStatus.ACTIVE).build());
        routeRepository.save(Route.builder().originHubId(3).destinationHubId(4).transitDays(3).mode(RouteMode.RAIL).status(RouteStatus.ACTIVE).build());
        log.info("Seeded 4 routes");
    }

    private void seedRateCards() {
        if (rateCardRepository.count() != 0) {
            return;
        }
        List<Carrier> carriers = carrierRepository.findAll();
        List<Route> routes = routeRepository.findAll();
        if (carriers.isEmpty() || routes.isEmpty()) {
            return;
        }
        int routeIdx = 0;
        for (Carrier carrier : carriers) {
            for (int i = 0; i < 2; i++) {
                Route route = routes.get(routeIdx % routes.size());
                routeIdx++;
                rateCardRepository.save(RateCard.builder().carrier(carrier).route(route).baseRate(new BigDecimal("500.00").add(new BigDecimal(i * 100))).weightSlab("0-100kg").effectiveDate(LocalDate.now()).expiryDate(LocalDate.now().plusYears(1)).status(RateCardStatus.ACTIVE).build());
            }
        }
        log.info("Seeded rate cards");
    }

    private void seedSuppliers() {
        if (supplierRepository.count() != 0) {
            return;
        }
        supplierRepository.save(Supplier.builder().name("Acme Electronics").category("Electronics").contactDetails("acme@suppliers.com").leadTimeDays(7).status(SupplierStatus.ACTIVE).build());
        supplierRepository.save(Supplier.builder().name("DailyGoods FMCG").category("FMCG").contactDetails("dailygoods@suppliers.com").leadTimeDays(3).status(SupplierStatus.ACTIVE).build());
        supplierRepository.save(Supplier.builder().name("AutoParts Co").category("Automotive").contactDetails("autoparts@suppliers.com").leadTimeDays(14).status(SupplierStatus.ACTIVE).build());
        log.info("Seeded 3 suppliers");
    }

    private void seedInventory() {
        if (inventoryRepository.count() != 0) {
            return;
        }
        for (int i = 1; i <= 10; i++) {
            int warehouseId = (i % 2 == 0) ? 2 : 1;
            inventoryRepository.save(WarehouseInventory.builder().sku("SKU-" + String.format("%04d", i)).productName("Product " + i).warehouseId(warehouseId).binLocation("A-" + i).quantityOnHand(100 + i * 10).quantityReserved(0).build());
        }
        log.info("Seeded 10 inventory items");
    }

    private void seedNotifications() {
        if (notificationRepository.count() != 0) {
            return;
        }
        notificationRepository.save(Notification.builder().userId(1).message("Welcome to LogiTrack").category(NotificationCategory.SHIPMENT).status(NotificationStatus.UNREAD).build());
        notificationRepository.save(Notification.builder().userId(2).message("New freight order assigned").category(NotificationCategory.SHIPMENT).status(NotificationStatus.UNREAD).build());
        notificationRepository.save(Notification.builder().userId(3).message("Inventory low in warehouse 1").category(NotificationCategory.WAREHOUSE).status(NotificationStatus.UNREAD).build());
        notificationRepository.save(Notification.builder().userId(4).message("Delivery scheduled for tomorrow").category(NotificationCategory.CARRIER).status(NotificationStatus.UNREAD).build());
        notificationRepository.save(Notification.builder().userId(5).message("Compliance document pending review").category(NotificationCategory.COMPLIANCE).status(NotificationStatus.UNREAD).build());
        log.info("Seeded 5 notifications");
    }
}

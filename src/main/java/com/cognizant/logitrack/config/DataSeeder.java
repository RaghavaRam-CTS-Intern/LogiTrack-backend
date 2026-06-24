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
import com.cognizant.logitrack.entity.FreightOrder;
import com.cognizant.logitrack.entity.Shipment;
import com.cognizant.logitrack.entity.ShipmentDocument;
import com.cognizant.logitrack.entity.DeliveryEvent;
import com.cognizant.logitrack.entity.InboundReceipt;
import com.cognizant.logitrack.entity.LogisticsReport;
import com.cognizant.logitrack.entity.PickList;
import com.cognizant.logitrack.entity.PurchaseOrder;
import com.cognizant.logitrack.entity.ComplianceFlag;
import com.cognizant.logitrack.repository.WarehouseInventoryRepository;
import com.cognizant.logitrack.repository.FreightOrderRepository;
import com.cognizant.logitrack.repository.ShipmentRepository;
import com.cognizant.logitrack.repository.ShipmentDocumentRepository;
import com.cognizant.logitrack.repository.DeliveryEventRepository;
import com.cognizant.logitrack.repository.InboundReceiptRepository;
import com.cognizant.logitrack.repository.LogisticsReportRepository;
import com.cognizant.logitrack.repository.PickListRepository;
import com.cognizant.logitrack.repository.PurchaseOrderRepository;
import com.cognizant.logitrack.repository.ComplianceFlagRepository;
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
    private final FreightOrderRepository freightOrderRepository;
    private final ShipmentRepository shipmentRepository;
    private final ShipmentDocumentRepository shipmentDocumentRepository;
    private final DeliveryEventRepository deliveryEventRepository;
    private final InboundReceiptRepository inboundReceiptRepository;
    private final LogisticsReportRepository logisticsReportRepository;
    private final PickListRepository pickListRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final ComplianceFlagRepository complianceFlagRepository;
    private final NotificationRepository notificationRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, AuditLogRepository auditLogRepository, CarrierRepository carrierRepository, RouteRepository routeRepository, RateCardRepository rateCardRepository, SupplierRepository supplierRepository, WarehouseInventoryRepository inventoryRepository, NotificationRepository notificationRepository, FreightOrderRepository freightOrderRepository, ShipmentRepository shipmentRepository, ShipmentDocumentRepository shipmentDocumentRepository, DeliveryEventRepository deliveryEventRepository, InboundReceiptRepository inboundReceiptRepository, LogisticsReportRepository logisticsReportRepository, PickListRepository pickListRepository, PurchaseOrderRepository purchaseOrderRepository, ComplianceFlagRepository complianceFlagRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.auditLogRepository = auditLogRepository;
        this.carrierRepository = carrierRepository;
        this.routeRepository = routeRepository;
        this.rateCardRepository = rateCardRepository;
        this.supplierRepository = supplierRepository;
        this.inventoryRepository = inventoryRepository;
        this.notificationRepository = notificationRepository;
        this.freightOrderRepository = freightOrderRepository;
        this.shipmentRepository = shipmentRepository;
        this.shipmentDocumentRepository = shipmentDocumentRepository;
        this.deliveryEventRepository = deliveryEventRepository;
        this.inboundReceiptRepository = inboundReceiptRepository;
        this.logisticsReportRepository = logisticsReportRepository;
        this.pickListRepository = pickListRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.complianceFlagRepository = complianceFlagRepository;
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
        seedFreightOrders();
        seedShipments();
        seedShipmentDocuments();
        seedDeliveryEvents();
        seedPurchaseOrders();
        seedInboundReceipts();
        seedPickLists();
        seedComplianceFlags();
        seedLogisticsReports();
        log.info("Data seeding complete.");
    }

    private void seedFreightOrders() {
        if (freightOrderRepository.count() != 0) {
            return;
        }
        List<FreightOrder> orders = new ArrayList<>();
        orders.add(FreightOrder.builder().shipperId(1).originLocationId(1).destinationLocationId(2).cargoDescription("Electronics").weight(new BigDecimal("120.5")).volume(new BigDecimal("1.2")).requiredDeliveryDate(LocalDate.now().plusDays(5)).status(com.cognizant.logitrack.enums.FreightOrderStatus.BOOKED).build());
        orders.add(FreightOrder.builder().shipperId(2).originLocationId(2).destinationLocationId(3).cargoDescription("FMCG Items").weight(new BigDecimal("80")).volume(new BigDecimal("0.8")).requiredDeliveryDate(LocalDate.now().plusDays(3)).status(com.cognizant.logitrack.enums.FreightOrderStatus.BOOKED).build());
        orders.add(FreightOrder.builder().shipperId(3).originLocationId(1).destinationLocationId(4).cargoDescription("Automotive parts").weight(new BigDecimal("450")).volume(new BigDecimal("4.5")).requiredDeliveryDate(LocalDate.now().plusDays(10)).status(com.cognizant.logitrack.enums.FreightOrderStatus.DRAFT).build());
        orders.add(FreightOrder.builder().shipperId(1).originLocationId(3).destinationLocationId(4).cargoDescription("Textiles").weight(new BigDecimal("200")).volume(new BigDecimal("2.5")).requiredDeliveryDate(LocalDate.now().plusDays(7)).status(com.cognizant.logitrack.enums.FreightOrderStatus.BOOKED).build());
        freightOrderRepository.saveAll(orders);
        log.info("Seeded {} freight orders", orders.size());
    }

    private void seedShipments() {
        if (shipmentRepository.count() != 0) {
            return;
        }
        List<FreightOrder> orders = freightOrderRepository.findAll();
        List<Carrier> carriers = carrierRepository.findAll();
        if (orders.isEmpty() || carriers.isEmpty()) return;
        List<Shipment> shipments = new ArrayList<>();
        int idx = 0;
        for (FreightOrder fo : orders) {
            Carrier c = carriers.get(idx % carriers.size());
            shipments.add(Shipment.builder().freightOrder(fo).carrierId(c.getCarrierId()).vehicleId(100 + idx).driverId(200 + idx).dispatchDate(LocalDate.now()).estimatedArrival(LocalDate.now().plusDays(3)).status(com.cognizant.logitrack.enums.ShipmentStatus.DISPATCHED).build());
            idx++;
        }
        shipmentRepository.saveAll(shipments);
        log.info("Seeded {} shipments", shipments.size());
    }

    private void seedShipmentDocuments() {
        if (shipmentDocumentRepository.count() != 0) return;
        List<Shipment> shipments = shipmentRepository.findAll();
        if (shipments.isEmpty()) return;
        List<ShipmentDocument> docs = new ArrayList<>();
        for (int i = 0; i < Math.min(5, shipments.size()); i++) {
            Shipment s = shipments.get(i);
            docs.add(ShipmentDocument.builder().shipmentId(s.getShipmentId()).documentType(com.cognizant.logitrack.enums.DocumentType.BOL).filePath("/docs/bol_" + s.getShipmentId() + ".pdf").submittedDate(LocalDate.now()).status(com.cognizant.logitrack.enums.DocumentStatus.SUBMITTED).build());
            docs.add(ShipmentDocument.builder().shipmentId(s.getShipmentId()).documentType(com.cognizant.logitrack.enums.DocumentType.PACKINGLIST).filePath("/docs/packing_" + s.getShipmentId() + ".pdf").submittedDate(LocalDate.now()).status(com.cognizant.logitrack.enums.DocumentStatus.PENDING).build());
        }
        shipmentDocumentRepository.saveAll(docs);
        log.info("Seeded {} shipment documents", docs.size());
    }

    private void seedDeliveryEvents() {
        if (deliveryEventRepository.count() != 0) return;
        List<Shipment> shipments = shipmentRepository.findAll();
        if (shipments.isEmpty()) return;
        List<DeliveryEvent> events = new ArrayList<>();
        for (Shipment s : shipments) {
            events.add(DeliveryEvent.builder().shipment(s).eventType(com.cognizant.logitrack.enums.EventType.PICKUP).locationId(1).notes("Picked up from origin").build());
            events.add(DeliveryEvent.builder().shipment(s).eventType(com.cognizant.logitrack.enums.EventType.INTRANSIT).locationId(2).notes("In transit").build());
        }
        deliveryEventRepository.saveAll(events);
        log.info("Seeded {} delivery events", events.size());
    }

    private void seedPurchaseOrders() {
        if (purchaseOrderRepository.count() != 0) return;
        List<Supplier> suppliers = supplierRepository.findAll();
        if (suppliers.isEmpty()) return;
        List<PurchaseOrder> pos = new ArrayList<>();
        for (int i = 0; i < suppliers.size(); i++) {
            Supplier s = suppliers.get(i);
            pos.add(PurchaseOrder.builder().supplier(s).warehouseId((i % 2) + 1).lineItems("[{\"sku\":\"SKU-0001\",\"qty\":100}]").totalValue(new BigDecimal("10000.00")).orderDate(LocalDate.now()).expectedDelivery(LocalDate.now().plusDays(7)).status(com.cognizant.logitrack.enums.POStatus.PLACED).build());
        }
        purchaseOrderRepository.saveAll(pos);
        log.info("Seeded {} purchase orders", pos.size());
    }

    private void seedInboundReceipts() {
        if (inboundReceiptRepository.count() != 0) return;
        List<PurchaseOrder> pos = purchaseOrderRepository.findAll();
        if (pos.isEmpty()) return;
        List<InboundReceipt> receipts = new ArrayList<>();
        for (int i = 0; i < pos.size(); i++) {
            PurchaseOrder po = pos.get(i);
            receipts.add(InboundReceipt.builder().supplierOrderId(po.getPoId()).warehouseId(po.getWarehouseId()).receivedDate(LocalDate.now()).receivedBy(1).status(com.cognizant.logitrack.enums.ReceiptStatus.RECEIVED).build());
        }
        inboundReceiptRepository.saveAll(receipts);
        log.info("Seeded {} inbound receipts", receipts.size());
    }

    private void seedPickLists() {
        if (pickListRepository.count() != 0) return;
        List<FreightOrder> orders = freightOrderRepository.findAll();
        if (orders.isEmpty()) return;
        List<PickList> lists = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            FreightOrder fo = orders.get(i);
            lists.add(PickList.builder().freightOrderId(fo.getFreightOrderId()).warehouseId((i % 2) + 1).assignedTo(300 + i).status(com.cognizant.logitrack.enums.PickListStatus.OPEN).build());
        }
        pickListRepository.saveAll(lists);
        log.info("Seeded {} pick lists", lists.size());
    }

    private void seedComplianceFlags() {
        if (complianceFlagRepository.count() != 0) return;
        List<Shipment> shipments = shipmentRepository.findAll();
        if (shipments.isEmpty()) return;
        List<ComplianceFlag> flags = new ArrayList<>();
        for (int i = 0; i < Math.min(3, shipments.size()); i++) {
            Shipment s = shipments.get(i);
            flags.add(ComplianceFlag.builder().shipmentId(s.getShipmentId()).flagType("DOCUMENT_MISSING").severity(com.cognizant.logitrack.enums.FlagSeverity.MEDIUM).status(com.cognizant.logitrack.enums.FlagStatus.OPEN).build());
        }
        complianceFlagRepository.saveAll(flags);
        log.info("Seeded {} compliance flags", flags.size());
    }

    private void seedLogisticsReports() {
        if (logisticsReportRepository.count() != 0) return;
        List<LogisticsReport> reports = new ArrayList<>();
        reports.add(LogisticsReport.builder().scope("DAILY").metrics("{\"onTime\":95,\"delayed\":5}").build());
        reports.add(LogisticsReport.builder().scope("WEEKLY").metrics("{\"onTime\":93,\"delayed\":7}").build());
        logisticsReportRepository.saveAll(reports);
        log.info("Seeded {} logistics reports", reports.size());
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

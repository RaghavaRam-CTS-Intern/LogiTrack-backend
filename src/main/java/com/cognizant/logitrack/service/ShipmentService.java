package com.cognizant.logitrack.service;

import com.cognizant.logitrack.exception.BadRequestException;
import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.DeliveryEventDTO;
import com.cognizant.logitrack.dto.DeliveryEventRequestDTO;
import com.cognizant.logitrack.dto.ShipmentDTO;
import com.cognizant.logitrack.dto.ShipmentRequestDTO;
import com.cognizant.logitrack.entity.DeliveryEvent;
import com.cognizant.logitrack.entity.FreightOrder;
import com.cognizant.logitrack.entity.Shipment;
import com.cognizant.logitrack.enums.ShipmentStatus;
import com.cognizant.logitrack.repository.DeliveryEventRepository;
import com.cognizant.logitrack.repository.FreightOrderRepository;
import com.cognizant.logitrack.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShipmentService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ShipmentService.class);
    private final ShipmentRepository shipmentRepository;
    private final FreightOrderRepository freightOrderRepository;
    private final DeliveryEventRepository deliveryEventRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, FreightOrderRepository freightOrderRepository, DeliveryEventRepository deliveryEventRepository) {
        this.shipmentRepository = shipmentRepository;
        this.freightOrderRepository = freightOrderRepository;
        this.deliveryEventRepository = deliveryEventRepository;
    }

    public ShipmentDTO createShipment(ShipmentRequestDTO dto) {
        FreightOrder freightOrder = freightOrderRepository.findById(dto.getFreightOrderId()).orElseThrow(() -> new BadRequestException("Freight order not found: " + dto.getFreightOrderId()));
        Shipment shipment = Shipment.builder().freightOrder(freightOrder).carrierId(dto.getCarrierId()).vehicleId(dto.getVehicleId()).driverId(dto.getDriverId()).dispatchDate(dto.getDispatchDate()).estimatedArrival(dto.getEstimatedArrival()).status(ShipmentStatus.DISPATCHED).build();
        Shipment saved = shipmentRepository.save(shipment);
        log.info("Shipment created: id={} for freightOrderId={}", saved.getShipmentId(), dto.getFreightOrderId());
        return toDTO(saved);
    }

    public ShipmentDTO getById(Integer id) {
        return toDTO(findEntity(id));
    }

    public ShipmentDTO updateShipmentStatus(Integer id, ShipmentStatus status) {
        Shipment shipment = findEntity(id);
        shipment.setStatus(status);
        Shipment saved = shipmentRepository.save(shipment);
        log.info("Shipment {} status updated to {}", id, status);
        return toDTO(saved);
    }

    public DeliveryEventDTO addDeliveryEvent(Integer shipmentId, DeliveryEventRequestDTO dto) {
        Shipment shipment = findEntity(shipmentId);
        DeliveryEvent event = DeliveryEvent.builder().shipment(shipment).eventType(dto.getEventType()).locationId(dto.getLocationId()).notes(dto.getNotes()).build();
        DeliveryEvent saved = deliveryEventRepository.save(event);
        log.info("Delivery event {} added to shipment {}", dto.getEventType(), shipmentId);
        return toEventDTO(saved);
    }

    public List<DeliveryEventDTO> getEventsByShipment(Integer shipmentId) {
        return deliveryEventRepository.findByShipment_ShipmentId(shipmentId).stream().map(this::toEventDTO).collect(Collectors.toList());
    }

    private Shipment findEntity(Integer id) {
        return shipmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + id));
    }

    private ShipmentDTO toDTO(Shipment shipment) {
        return ShipmentDTO.builder().shipmentId(shipment.getShipmentId()).freightOrderId(shipment.getFreightOrder() != null ? shipment.getFreightOrder().getFreightOrderId() : null).carrierId(shipment.getCarrierId()).vehicleId(shipment.getVehicleId()).driverId(shipment.getDriverId()).dispatchDate(shipment.getDispatchDate()).estimatedArrival(shipment.getEstimatedArrival()).actualArrival(shipment.getActualArrival()).status(shipment.getStatus()).build();
    }

    private DeliveryEventDTO toEventDTO(DeliveryEvent event) {
        return DeliveryEventDTO.builder().eventId(event.getEventId()).shipmentId(event.getShipment() != null ? event.getShipment().getShipmentId() : null).eventType(event.getEventType()).timestamp(event.getTimestamp()).locationId(event.getLocationId()).notes(event.getNotes()).build();
    }
}

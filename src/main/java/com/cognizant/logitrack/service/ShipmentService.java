package com.cognizant.logitrack.service;

import com.cognizant.logitrack.dto.DeliveryEventDTO;
import com.cognizant.logitrack.dto.DeliveryEventRequestDTO;
import com.cognizant.logitrack.dto.ShipmentDTO;
import com.cognizant.logitrack.dto.ShipmentRequestDTO;
import com.cognizant.logitrack.enums.ShipmentStatus;
import java.util.List;

public interface ShipmentService {
    ShipmentDTO createShipment(ShipmentRequestDTO dto);
    ShipmentDTO getById(Integer id);
    ShipmentDTO updateShipmentStatus(Integer id, ShipmentStatus status);
    DeliveryEventDTO addDeliveryEvent(Integer shipmentId, DeliveryEventRequestDTO dto);
    List<DeliveryEventDTO> getEventsByShipment(Integer shipmentId);
}

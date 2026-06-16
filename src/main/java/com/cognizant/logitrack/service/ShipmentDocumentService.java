package com.cognizant.logitrack.service;

import com.cognizant.logitrack.dto.ShipmentDocumentDTO;
import com.cognizant.logitrack.dto.ShipmentDocumentRequestDTO;
import com.cognizant.logitrack.enums.DocumentStatus;
import java.util.List;

public interface ShipmentDocumentService {
    ShipmentDocumentDTO uploadDocument(ShipmentDocumentRequestDTO dto);
    ShipmentDocumentDTO updateDocumentStatus(Integer id, DocumentStatus status);
    List<ShipmentDocumentDTO> getDocsByShipment(Integer shipmentId);
    ShipmentDocumentDTO getById(Integer id);
}

package com.cognizant.logitrack.service;

import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.ShipmentDocumentDTO;
import com.cognizant.logitrack.dto.ShipmentDocumentRequestDTO;
import com.cognizant.logitrack.entity.ShipmentDocument;
import com.cognizant.logitrack.enums.DocumentStatus;
import com.cognizant.logitrack.repository.ShipmentDocumentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentDocumentService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ShipmentDocumentService.class);
    private final ShipmentDocumentRepository documentRepository;

    public ShipmentDocumentService(ShipmentDocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public ShipmentDocumentDTO uploadDocument(ShipmentDocumentRequestDTO dto) {
        ShipmentDocument document = ShipmentDocument.builder().shipmentId(dto.getShipmentId()).documentType(dto.getDocumentType()).filePath(dto.getFilePath()).submittedDate(dto.getSubmittedDate()).status(DocumentStatus.PENDING).build();
        ShipmentDocument saved = documentRepository.save(document);
        log.info("Document uploaded: id={}, shipmentId={}", saved.getDocumentId(), saved.getShipmentId());
        return toDTO(saved);
    }

    public ShipmentDocumentDTO updateDocumentStatus(Integer id, DocumentStatus status) {
        ShipmentDocument document = findEntity(id);
        document.setStatus(status);
        return toDTO(documentRepository.save(document));
    }

    public List<ShipmentDocumentDTO> getDocsByShipment(Integer shipmentId) {
        return documentRepository.findByShipmentId(shipmentId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ShipmentDocumentDTO getById(Integer id) {
        return toDTO(findEntity(id));
    }

    private ShipmentDocument findEntity(Integer id) {
        return documentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Shipment document not found with id: " + id));
    }

    private ShipmentDocumentDTO toDTO(ShipmentDocument d) {
        return ShipmentDocumentDTO.builder().documentId(d.getDocumentId()).shipmentId(d.getShipmentId()).documentType(d.getDocumentType()).filePath(d.getFilePath()).submittedDate(d.getSubmittedDate()).status(d.getStatus()).build();
    }
}

package com.cognizant.logitrack.service;

import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.ComplianceFlagDTO;
import com.cognizant.logitrack.dto.ComplianceFlagRequestDTO;
import com.cognizant.logitrack.entity.ComplianceFlag;
import com.cognizant.logitrack.enums.FlagStatus;
import com.cognizant.logitrack.repository.ComplianceFlagRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplianceFlagService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ComplianceFlagService.class);
    private final ComplianceFlagRepository flagRepository;

    public ComplianceFlagService(ComplianceFlagRepository flagRepository) {
        this.flagRepository = flagRepository;
    }

    public ComplianceFlagDTO raiseFlag(ComplianceFlagRequestDTO dto) {
        ComplianceFlag flag = ComplianceFlag.builder().shipmentId(dto.getShipmentId()).flagType(dto.getFlagType()).severity(dto.getSeverity()).status(FlagStatus.OPEN).build();
        ComplianceFlag saved = flagRepository.save(flag);
        log.info("Compliance flag raised: id={}, shipmentId={}", saved.getFlagId(), saved.getShipmentId());
        return toDTO(saved);
    }

    public ComplianceFlagDTO resolveFlag(Integer id) {
        ComplianceFlag flag = findEntity(id);
        flag.setStatus(FlagStatus.RESOLVED);
        log.info("Compliance flag {} resolved", id);
        return toDTO(flagRepository.save(flag));
    }

    public List<ComplianceFlagDTO> getFlagsByShipment(Integer shipmentId) {
        return flagRepository.findByShipmentId(shipmentId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ComplianceFlagDTO> getOpenFlags() {
        return flagRepository.findByStatus(FlagStatus.OPEN).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ComplianceFlagDTO getById(Integer id) {
        return toDTO(findEntity(id));
    }

    private ComplianceFlag findEntity(Integer id) {
        return flagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Compliance flag not found with id: " + id));
    }

    private ComplianceFlagDTO toDTO(ComplianceFlag f) {
        return ComplianceFlagDTO.builder().flagId(f.getFlagId()).shipmentId(f.getShipmentId()).flagType(f.getFlagType()).severity(f.getSeverity()).raisedDate(f.getRaisedDate()).status(f.getStatus()).build();
    }
}

package com.cognizant.logitrack.service;

import com.cognizant.logitrack.dto.ComplianceFlagDTO;
import com.cognizant.logitrack.dto.ComplianceFlagRequestDTO;
import java.util.List;

public interface ComplianceFlagService {
    ComplianceFlagDTO raiseFlag(ComplianceFlagRequestDTO dto);
    ComplianceFlagDTO resolveFlag(Integer id);
    List<ComplianceFlagDTO> getFlagsByShipment(Integer shipmentId);
    List<ComplianceFlagDTO> getOpenFlags();
    ComplianceFlagDTO getById(Integer id);
}

package com.cognizant.logitrack.service;

import com.cognizant.logitrack.dto.RateCardDTO;
import com.cognizant.logitrack.dto.RateCardRequestDTO;
import com.cognizant.logitrack.enums.RateCardStatus;
import java.util.List;

public interface RateCardService {
    RateCardDTO addRateCard(RateCardRequestDTO dto);
    List<RateCardDTO> getRateCardsByCarrier(Integer carrierId);
    List<RateCardDTO> getRateCardsByRoute(Integer routeId);
    RateCardDTO getById(Integer id);
    RateCardDTO updateStatus(Integer id, RateCardStatus status);
}

package com.cognizant.logitrack.service;

import com.cognizant.logitrack.exception.BadRequestException;
import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.RateCardDTO;
import com.cognizant.logitrack.dto.RateCardRequestDTO;
import com.cognizant.logitrack.entity.Carrier;
import com.cognizant.logitrack.entity.RateCard;
import com.cognizant.logitrack.entity.Route;
import com.cognizant.logitrack.enums.RateCardStatus;
import com.cognizant.logitrack.repository.CarrierRepository;
import com.cognizant.logitrack.repository.RateCardRepository;
import com.cognizant.logitrack.repository.RouteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RateCardService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RateCardService.class);
    private final RateCardRepository rateCardRepository;
    private final CarrierRepository carrierRepository;
    private final RouteRepository routeRepository;

    public RateCardService(RateCardRepository rateCardRepository, CarrierRepository carrierRepository, RouteRepository routeRepository) {
        this.rateCardRepository = rateCardRepository;
        this.carrierRepository = carrierRepository;
        this.routeRepository = routeRepository;
    }

    public RateCardDTO addRateCard(RateCardRequestDTO dto) {
        Carrier carrier = carrierRepository.findById(dto.getCarrierId()).orElseThrow(() -> new BadRequestException("Carrier not found"));
        Route route = routeRepository.findById(dto.getRouteId()).orElseThrow(() -> new BadRequestException("Route not found"));
        RateCard rateCard = RateCard.builder().carrier(carrier).route(route).baseRate(dto.getBaseRate()).weightSlab(dto.getWeightSlab()).effectiveDate(dto.getEffectiveDate()).expiryDate(dto.getExpiryDate()).status(RateCardStatus.ACTIVE).build();
        RateCard saved = rateCardRepository.save(rateCard);
        log.info("Rate card added: id={}", saved.getRateCardId());
        return toDTO(saved);
    }

    public List<RateCardDTO> getRateCardsByCarrier(Integer carrierId) {
        return rateCardRepository.findByCarrier_CarrierId(carrierId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<RateCardDTO> getRateCardsByRoute(Integer routeId) {
        return rateCardRepository.findByRoute_RouteId(routeId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public RateCardDTO getById(Integer id) {
        return toDTO(findEntity(id));
    }

    public RateCardDTO updateStatus(Integer id, RateCardStatus status) {
        RateCard rateCard = findEntity(id);
        rateCard.setStatus(status);
        return toDTO(rateCardRepository.save(rateCard));
    }

    private RateCard findEntity(Integer id) {
        return rateCardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rate card not found with id: " + id));
    }

    private RateCardDTO toDTO(RateCard rc) {
        return RateCardDTO.builder().rateCardId(rc.getRateCardId()).carrierId(rc.getCarrier() != null ? rc.getCarrier().getCarrierId() : null).routeId(rc.getRoute() != null ? rc.getRoute().getRouteId() : null).baseRate(rc.getBaseRate()).weightSlab(rc.getWeightSlab()).effectiveDate(rc.getEffectiveDate()).expiryDate(rc.getExpiryDate()).status(rc.getStatus()).build();
    }
}

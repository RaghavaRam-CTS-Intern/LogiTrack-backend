package com.cognizant.logitrack.repository;

import com.cognizant.logitrack.entity.RateCard;
import com.cognizant.logitrack.enums.RateCardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateCardRepository extends JpaRepository<RateCard, Integer> {
    List<RateCard> findByCarrier_CarrierId(Integer carrierId);
    List<RateCard> findByRoute_RouteId(Integer routeId);
    List<RateCard> findByStatus(RateCardStatus status);
}

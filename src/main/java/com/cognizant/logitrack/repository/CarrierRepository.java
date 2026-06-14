package com.cognizant.logitrack.repository;

import com.cognizant.logitrack.entity.Carrier;
import com.cognizant.logitrack.enums.CarrierStatus;
import com.cognizant.logitrack.enums.RouteMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Integer> {
    List<Carrier> findByStatus(CarrierStatus status);
    List<Carrier> findByMode(RouteMode mode);
}

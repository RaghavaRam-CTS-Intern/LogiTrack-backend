package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.ShipmentStatus;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentDTO {
    private Integer shipmentId;
    @NotNull
    private Integer freightOrderId;
    @NotNull
    private Integer carrierId;
    private Integer vehicleId;
    private Integer driverId;
    private LocalDate dispatchDate;
    private LocalDate estimatedArrival;
    private LocalDate actualArrival;
    private ShipmentStatus status;
}

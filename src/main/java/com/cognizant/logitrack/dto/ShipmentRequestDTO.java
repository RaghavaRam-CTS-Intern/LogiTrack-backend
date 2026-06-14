package com.cognizant.logitrack.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ShipmentRequestDTO {
    @NotNull
    private Integer freightOrderId;
    @NotNull
    private Integer carrierId;
    private Integer vehicleId;
    private Integer driverId;
    private LocalDate dispatchDate;
    private LocalDate estimatedArrival;

    public Integer getFreightOrderId() {
        return this.freightOrderId;
    }

    public Integer getCarrierId() {
        return this.carrierId;
    }

    public Integer getVehicleId() {
        return this.vehicleId;
    }

    public Integer getDriverId() {
        return this.driverId;
    }

    public LocalDate getDispatchDate() {
        return this.dispatchDate;
    }

    public LocalDate getEstimatedArrival() {
        return this.estimatedArrival;
    }

    public void setFreightOrderId(final Integer freightOrderId) {
        this.freightOrderId = freightOrderId;
    }

    public void setCarrierId(final Integer carrierId) {
        this.carrierId = carrierId;
    }

    public void setVehicleId(final Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setDriverId(final Integer driverId) {
        this.driverId = driverId;
    }

    public void setDispatchDate(final LocalDate dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public void setEstimatedArrival(final LocalDate estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ShipmentRequestDTO)) return false;
        final ShipmentRequestDTO other = (ShipmentRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$freightOrderId = this.getFreightOrderId();
        final java.lang.Object other$freightOrderId = other.getFreightOrderId();
        if (this$freightOrderId == null ? other$freightOrderId != null : !this$freightOrderId.equals(other$freightOrderId)) return false;
        final java.lang.Object this$carrierId = this.getCarrierId();
        final java.lang.Object other$carrierId = other.getCarrierId();
        if (this$carrierId == null ? other$carrierId != null : !this$carrierId.equals(other$carrierId)) return false;
        final java.lang.Object this$vehicleId = this.getVehicleId();
        final java.lang.Object other$vehicleId = other.getVehicleId();
        if (this$vehicleId == null ? other$vehicleId != null : !this$vehicleId.equals(other$vehicleId)) return false;
        final java.lang.Object this$driverId = this.getDriverId();
        final java.lang.Object other$driverId = other.getDriverId();
        if (this$driverId == null ? other$driverId != null : !this$driverId.equals(other$driverId)) return false;
        final java.lang.Object this$dispatchDate = this.getDispatchDate();
        final java.lang.Object other$dispatchDate = other.getDispatchDate();
        if (this$dispatchDate == null ? other$dispatchDate != null : !this$dispatchDate.equals(other$dispatchDate)) return false;
        final java.lang.Object this$estimatedArrival = this.getEstimatedArrival();
        final java.lang.Object other$estimatedArrival = other.getEstimatedArrival();
        if (this$estimatedArrival == null ? other$estimatedArrival != null : !this$estimatedArrival.equals(other$estimatedArrival)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ShipmentRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $freightOrderId = this.getFreightOrderId();
        result = result * PRIME + ($freightOrderId == null ? 43 : $freightOrderId.hashCode());
        final java.lang.Object $carrierId = this.getCarrierId();
        result = result * PRIME + ($carrierId == null ? 43 : $carrierId.hashCode());
        final java.lang.Object $vehicleId = this.getVehicleId();
        result = result * PRIME + ($vehicleId == null ? 43 : $vehicleId.hashCode());
        final java.lang.Object $driverId = this.getDriverId();
        result = result * PRIME + ($driverId == null ? 43 : $driverId.hashCode());
        final java.lang.Object $dispatchDate = this.getDispatchDate();
        result = result * PRIME + ($dispatchDate == null ? 43 : $dispatchDate.hashCode());
        final java.lang.Object $estimatedArrival = this.getEstimatedArrival();
        result = result * PRIME + ($estimatedArrival == null ? 43 : $estimatedArrival.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ShipmentRequestDTO(freightOrderId=" + this.getFreightOrderId() + ", carrierId=" + this.getCarrierId() + ", vehicleId=" + this.getVehicleId() + ", driverId=" + this.getDriverId() + ", dispatchDate=" + this.getDispatchDate() + ", estimatedArrival=" + this.getEstimatedArrival() + ")";
    }

    public ShipmentRequestDTO() {
    }

    public ShipmentRequestDTO(final Integer freightOrderId, final Integer carrierId, final Integer vehicleId, final Integer driverId, final LocalDate dispatchDate, final LocalDate estimatedArrival) {
        this.freightOrderId = freightOrderId;
        this.carrierId = carrierId;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.dispatchDate = dispatchDate;
        this.estimatedArrival = estimatedArrival;
    }
}

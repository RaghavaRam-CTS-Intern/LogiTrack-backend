package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.ShipmentStatus;
import java.time.LocalDate;

public class ShipmentDTO {
    private Integer shipmentId;
    private Integer freightOrderId;
    private Integer carrierId;
    private Integer vehicleId;
    private Integer driverId;
    private LocalDate dispatchDate;
    private LocalDate estimatedArrival;
    private LocalDate actualArrival;
    private ShipmentStatus status;


    public static class ShipmentDTOBuilder {
        private Integer shipmentId;
        private Integer freightOrderId;
        private Integer carrierId;
        private Integer vehicleId;
        private Integer driverId;
        private LocalDate dispatchDate;
        private LocalDate estimatedArrival;
        private LocalDate actualArrival;
        private ShipmentStatus status;

        ShipmentDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDTO.ShipmentDTOBuilder shipmentId(final Integer shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDTO.ShipmentDTOBuilder freightOrderId(final Integer freightOrderId) {
            this.freightOrderId = freightOrderId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDTO.ShipmentDTOBuilder carrierId(final Integer carrierId) {
            this.carrierId = carrierId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDTO.ShipmentDTOBuilder vehicleId(final Integer vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDTO.ShipmentDTOBuilder driverId(final Integer driverId) {
            this.driverId = driverId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDTO.ShipmentDTOBuilder dispatchDate(final LocalDate dispatchDate) {
            this.dispatchDate = dispatchDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDTO.ShipmentDTOBuilder estimatedArrival(final LocalDate estimatedArrival) {
            this.estimatedArrival = estimatedArrival;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDTO.ShipmentDTOBuilder actualArrival(final LocalDate actualArrival) {
            this.actualArrival = actualArrival;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDTO.ShipmentDTOBuilder status(final ShipmentStatus status) {
            this.status = status;
            return this;
        }

        public ShipmentDTO build() {
            return new ShipmentDTO(this.shipmentId, this.freightOrderId, this.carrierId, this.vehicleId, this.driverId, this.dispatchDate, this.estimatedArrival, this.actualArrival, this.status);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "ShipmentDTO.ShipmentDTOBuilder(shipmentId=" + this.shipmentId + ", freightOrderId=" + this.freightOrderId + ", carrierId=" + this.carrierId + ", vehicleId=" + this.vehicleId + ", driverId=" + this.driverId + ", dispatchDate=" + this.dispatchDate + ", estimatedArrival=" + this.estimatedArrival + ", actualArrival=" + this.actualArrival + ", status=" + this.status + ")";
        }
    }

    public static ShipmentDTO.ShipmentDTOBuilder builder() {
        return new ShipmentDTO.ShipmentDTOBuilder();
    }

    public Integer getShipmentId() {
        return this.shipmentId;
    }

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

    public LocalDate getActualArrival() {
        return this.actualArrival;
    }

    public ShipmentStatus getStatus() {
        return this.status;
    }

    public void setShipmentId(final Integer shipmentId) {
        this.shipmentId = shipmentId;
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

    public void setActualArrival(final LocalDate actualArrival) {
        this.actualArrival = actualArrival;
    }

    public void setStatus(final ShipmentStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ShipmentDTO)) return false;
        final ShipmentDTO other = (ShipmentDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$shipmentId = this.getShipmentId();
        final java.lang.Object other$shipmentId = other.getShipmentId();
        if (this$shipmentId == null ? other$shipmentId != null : !this$shipmentId.equals(other$shipmentId)) return false;
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
        final java.lang.Object this$actualArrival = this.getActualArrival();
        final java.lang.Object other$actualArrival = other.getActualArrival();
        if (this$actualArrival == null ? other$actualArrival != null : !this$actualArrival.equals(other$actualArrival)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ShipmentDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $shipmentId = this.getShipmentId();
        result = result * PRIME + ($shipmentId == null ? 43 : $shipmentId.hashCode());
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
        final java.lang.Object $actualArrival = this.getActualArrival();
        result = result * PRIME + ($actualArrival == null ? 43 : $actualArrival.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ShipmentDTO(shipmentId=" + this.getShipmentId() + ", freightOrderId=" + this.getFreightOrderId() + ", carrierId=" + this.getCarrierId() + ", vehicleId=" + this.getVehicleId() + ", driverId=" + this.getDriverId() + ", dispatchDate=" + this.getDispatchDate() + ", estimatedArrival=" + this.getEstimatedArrival() + ", actualArrival=" + this.getActualArrival() + ", status=" + this.getStatus() + ")";
    }

    public ShipmentDTO() {
    }

    public ShipmentDTO(final Integer shipmentId, final Integer freightOrderId, final Integer carrierId, final Integer vehicleId, final Integer driverId, final LocalDate dispatchDate, final LocalDate estimatedArrival, final LocalDate actualArrival, final ShipmentStatus status) {
        this.shipmentId = shipmentId;
        this.freightOrderId = freightOrderId;
        this.carrierId = carrierId;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.dispatchDate = dispatchDate;
        this.estimatedArrival = estimatedArrival;
        this.actualArrival = actualArrival;
        this.status = status;
    }
}

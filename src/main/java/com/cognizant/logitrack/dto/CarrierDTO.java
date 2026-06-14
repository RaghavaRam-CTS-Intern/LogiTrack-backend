package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.CarrierServiceLevel;
import com.cognizant.logitrack.enums.CarrierStatus;
import com.cognizant.logitrack.enums.RouteMode;

public class CarrierDTO {
    private Integer carrierId;
    private String name;
    private RouteMode mode;
    private CarrierServiceLevel serviceLevel;
    private String contactDetails;
    private CarrierStatus status;


    public static class CarrierDTOBuilder {
        private Integer carrierId;
        private String name;
        private RouteMode mode;
        private CarrierServiceLevel serviceLevel;
        private String contactDetails;
        private CarrierStatus status;

        CarrierDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public CarrierDTO.CarrierDTOBuilder carrierId(final Integer carrierId) {
            this.carrierId = carrierId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public CarrierDTO.CarrierDTOBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public CarrierDTO.CarrierDTOBuilder mode(final RouteMode mode) {
            this.mode = mode;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public CarrierDTO.CarrierDTOBuilder serviceLevel(final CarrierServiceLevel serviceLevel) {
            this.serviceLevel = serviceLevel;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public CarrierDTO.CarrierDTOBuilder contactDetails(final String contactDetails) {
            this.contactDetails = contactDetails;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public CarrierDTO.CarrierDTOBuilder status(final CarrierStatus status) {
            this.status = status;
            return this;
        }

        public CarrierDTO build() {
            return new CarrierDTO(this.carrierId, this.name, this.mode, this.serviceLevel, this.contactDetails, this.status);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "CarrierDTO.CarrierDTOBuilder(carrierId=" + this.carrierId + ", name=" + this.name + ", mode=" + this.mode + ", serviceLevel=" + this.serviceLevel + ", contactDetails=" + this.contactDetails + ", status=" + this.status + ")";
        }
    }

    public static CarrierDTO.CarrierDTOBuilder builder() {
        return new CarrierDTO.CarrierDTOBuilder();
    }

    public Integer getCarrierId() {
        return this.carrierId;
    }

    public String getName() {
        return this.name;
    }

    public RouteMode getMode() {
        return this.mode;
    }

    public CarrierServiceLevel getServiceLevel() {
        return this.serviceLevel;
    }

    public String getContactDetails() {
        return this.contactDetails;
    }

    public CarrierStatus getStatus() {
        return this.status;
    }

    public void setCarrierId(final Integer carrierId) {
        this.carrierId = carrierId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setMode(final RouteMode mode) {
        this.mode = mode;
    }

    public void setServiceLevel(final CarrierServiceLevel serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    public void setContactDetails(final String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setStatus(final CarrierStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CarrierDTO)) return false;
        final CarrierDTO other = (CarrierDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$carrierId = this.getCarrierId();
        final java.lang.Object other$carrierId = other.getCarrierId();
        if (this$carrierId == null ? other$carrierId != null : !this$carrierId.equals(other$carrierId)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$mode = this.getMode();
        final java.lang.Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) return false;
        final java.lang.Object this$serviceLevel = this.getServiceLevel();
        final java.lang.Object other$serviceLevel = other.getServiceLevel();
        if (this$serviceLevel == null ? other$serviceLevel != null : !this$serviceLevel.equals(other$serviceLevel)) return false;
        final java.lang.Object this$contactDetails = this.getContactDetails();
        final java.lang.Object other$contactDetails = other.getContactDetails();
        if (this$contactDetails == null ? other$contactDetails != null : !this$contactDetails.equals(other$contactDetails)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CarrierDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $carrierId = this.getCarrierId();
        result = result * PRIME + ($carrierId == null ? 43 : $carrierId.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $mode = this.getMode();
        result = result * PRIME + ($mode == null ? 43 : $mode.hashCode());
        final java.lang.Object $serviceLevel = this.getServiceLevel();
        result = result * PRIME + ($serviceLevel == null ? 43 : $serviceLevel.hashCode());
        final java.lang.Object $contactDetails = this.getContactDetails();
        result = result * PRIME + ($contactDetails == null ? 43 : $contactDetails.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CarrierDTO(carrierId=" + this.getCarrierId() + ", name=" + this.getName() + ", mode=" + this.getMode() + ", serviceLevel=" + this.getServiceLevel() + ", contactDetails=" + this.getContactDetails() + ", status=" + this.getStatus() + ")";
    }

    public CarrierDTO() {
    }

    public CarrierDTO(final Integer carrierId, final String name, final RouteMode mode, final CarrierServiceLevel serviceLevel, final String contactDetails, final CarrierStatus status) {
        this.carrierId = carrierId;
        this.name = name;
        this.mode = mode;
        this.serviceLevel = serviceLevel;
        this.contactDetails = contactDetails;
        this.status = status;
    }
}

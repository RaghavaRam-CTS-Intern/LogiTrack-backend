package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.CarrierServiceLevel;
import com.cognizant.logitrack.enums.RouteMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarrierRequestDTO {
    @NotBlank
    private String name;
    @NotNull
    private RouteMode mode;
    @NotNull
    private CarrierServiceLevel serviceLevel;
    private String contactDetails;

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

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CarrierRequestDTO)) return false;
        final CarrierRequestDTO other = (CarrierRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
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
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CarrierRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $mode = this.getMode();
        result = result * PRIME + ($mode == null ? 43 : $mode.hashCode());
        final java.lang.Object $serviceLevel = this.getServiceLevel();
        result = result * PRIME + ($serviceLevel == null ? 43 : $serviceLevel.hashCode());
        final java.lang.Object $contactDetails = this.getContactDetails();
        result = result * PRIME + ($contactDetails == null ? 43 : $contactDetails.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CarrierRequestDTO(name=" + this.getName() + ", mode=" + this.getMode() + ", serviceLevel=" + this.getServiceLevel() + ", contactDetails=" + this.getContactDetails() + ")";
    }

    public CarrierRequestDTO() {
    }

    public CarrierRequestDTO(final String name, final RouteMode mode, final CarrierServiceLevel serviceLevel, final String contactDetails) {
        this.name = name;
        this.mode = mode;
        this.serviceLevel = serviceLevel;
        this.contactDetails = contactDetails;
    }
}

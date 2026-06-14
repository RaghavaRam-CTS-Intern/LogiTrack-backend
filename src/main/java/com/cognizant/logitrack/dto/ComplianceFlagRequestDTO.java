package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.FlagSeverity;
import jakarta.validation.constraints.NotNull;

public class ComplianceFlagRequestDTO {
    @NotNull
    private Integer shipmentId;
    private String flagType;
    @NotNull
    private FlagSeverity severity;

    public Integer getShipmentId() {
        return this.shipmentId;
    }

    public String getFlagType() {
        return this.flagType;
    }

    public FlagSeverity getSeverity() {
        return this.severity;
    }

    public void setShipmentId(final Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setFlagType(final String flagType) {
        this.flagType = flagType;
    }

    public void setSeverity(final FlagSeverity severity) {
        this.severity = severity;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ComplianceFlagRequestDTO)) return false;
        final ComplianceFlagRequestDTO other = (ComplianceFlagRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$shipmentId = this.getShipmentId();
        final java.lang.Object other$shipmentId = other.getShipmentId();
        if (this$shipmentId == null ? other$shipmentId != null : !this$shipmentId.equals(other$shipmentId)) return false;
        final java.lang.Object this$flagType = this.getFlagType();
        final java.lang.Object other$flagType = other.getFlagType();
        if (this$flagType == null ? other$flagType != null : !this$flagType.equals(other$flagType)) return false;
        final java.lang.Object this$severity = this.getSeverity();
        final java.lang.Object other$severity = other.getSeverity();
        if (this$severity == null ? other$severity != null : !this$severity.equals(other$severity)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ComplianceFlagRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $shipmentId = this.getShipmentId();
        result = result * PRIME + ($shipmentId == null ? 43 : $shipmentId.hashCode());
        final java.lang.Object $flagType = this.getFlagType();
        result = result * PRIME + ($flagType == null ? 43 : $flagType.hashCode());
        final java.lang.Object $severity = this.getSeverity();
        result = result * PRIME + ($severity == null ? 43 : $severity.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ComplianceFlagRequestDTO(shipmentId=" + this.getShipmentId() + ", flagType=" + this.getFlagType() + ", severity=" + this.getSeverity() + ")";
    }

    public ComplianceFlagRequestDTO() {
    }

    public ComplianceFlagRequestDTO(final Integer shipmentId, final String flagType, final FlagSeverity severity) {
        this.shipmentId = shipmentId;
        this.flagType = flagType;
        this.severity = severity;
    }
}

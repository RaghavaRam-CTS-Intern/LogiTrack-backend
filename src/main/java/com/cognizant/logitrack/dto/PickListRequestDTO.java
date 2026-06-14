package com.cognizant.logitrack.dto;

import jakarta.validation.constraints.NotNull;

public class PickListRequestDTO {
    @NotNull
    private Integer freightOrderId;
    @NotNull
    private Integer warehouseId;
    private Integer assignedTo;

    public Integer getFreightOrderId() {
        return this.freightOrderId;
    }

    public Integer getWarehouseId() {
        return this.warehouseId;
    }

    public Integer getAssignedTo() {
        return this.assignedTo;
    }

    public void setFreightOrderId(final Integer freightOrderId) {
        this.freightOrderId = freightOrderId;
    }

    public void setWarehouseId(final Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setAssignedTo(final Integer assignedTo) {
        this.assignedTo = assignedTo;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof PickListRequestDTO)) return false;
        final PickListRequestDTO other = (PickListRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$freightOrderId = this.getFreightOrderId();
        final java.lang.Object other$freightOrderId = other.getFreightOrderId();
        if (this$freightOrderId == null ? other$freightOrderId != null : !this$freightOrderId.equals(other$freightOrderId)) return false;
        final java.lang.Object this$warehouseId = this.getWarehouseId();
        final java.lang.Object other$warehouseId = other.getWarehouseId();
        if (this$warehouseId == null ? other$warehouseId != null : !this$warehouseId.equals(other$warehouseId)) return false;
        final java.lang.Object this$assignedTo = this.getAssignedTo();
        final java.lang.Object other$assignedTo = other.getAssignedTo();
        if (this$assignedTo == null ? other$assignedTo != null : !this$assignedTo.equals(other$assignedTo)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof PickListRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $freightOrderId = this.getFreightOrderId();
        result = result * PRIME + ($freightOrderId == null ? 43 : $freightOrderId.hashCode());
        final java.lang.Object $warehouseId = this.getWarehouseId();
        result = result * PRIME + ($warehouseId == null ? 43 : $warehouseId.hashCode());
        final java.lang.Object $assignedTo = this.getAssignedTo();
        result = result * PRIME + ($assignedTo == null ? 43 : $assignedTo.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PickListRequestDTO(freightOrderId=" + this.getFreightOrderId() + ", warehouseId=" + this.getWarehouseId() + ", assignedTo=" + this.getAssignedTo() + ")";
    }

    public PickListRequestDTO() {
    }

    public PickListRequestDTO(final Integer freightOrderId, final Integer warehouseId, final Integer assignedTo) {
        this.freightOrderId = freightOrderId;
        this.warehouseId = warehouseId;
        this.assignedTo = assignedTo;
    }
}

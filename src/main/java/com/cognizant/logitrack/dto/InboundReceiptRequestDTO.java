package com.cognizant.logitrack.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class InboundReceiptRequestDTO {
    @NotNull
    private Integer supplierOrderId;
    @NotNull
    private Integer warehouseId;
    private LocalDate receivedDate;
    private Integer receivedBy;

    public Integer getSupplierOrderId() {
        return this.supplierOrderId;
    }

    public Integer getWarehouseId() {
        return this.warehouseId;
    }

    public LocalDate getReceivedDate() {
        return this.receivedDate;
    }

    public Integer getReceivedBy() {
        return this.receivedBy;
    }

    public void setSupplierOrderId(final Integer supplierOrderId) {
        this.supplierOrderId = supplierOrderId;
    }

    public void setWarehouseId(final Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setReceivedDate(final LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public void setReceivedBy(final Integer receivedBy) {
        this.receivedBy = receivedBy;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof InboundReceiptRequestDTO)) return false;
        final InboundReceiptRequestDTO other = (InboundReceiptRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$supplierOrderId = this.getSupplierOrderId();
        final java.lang.Object other$supplierOrderId = other.getSupplierOrderId();
        if (this$supplierOrderId == null ? other$supplierOrderId != null : !this$supplierOrderId.equals(other$supplierOrderId)) return false;
        final java.lang.Object this$warehouseId = this.getWarehouseId();
        final java.lang.Object other$warehouseId = other.getWarehouseId();
        if (this$warehouseId == null ? other$warehouseId != null : !this$warehouseId.equals(other$warehouseId)) return false;
        final java.lang.Object this$receivedBy = this.getReceivedBy();
        final java.lang.Object other$receivedBy = other.getReceivedBy();
        if (this$receivedBy == null ? other$receivedBy != null : !this$receivedBy.equals(other$receivedBy)) return false;
        final java.lang.Object this$receivedDate = this.getReceivedDate();
        final java.lang.Object other$receivedDate = other.getReceivedDate();
        if (this$receivedDate == null ? other$receivedDate != null : !this$receivedDate.equals(other$receivedDate)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof InboundReceiptRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $supplierOrderId = this.getSupplierOrderId();
        result = result * PRIME + ($supplierOrderId == null ? 43 : $supplierOrderId.hashCode());
        final java.lang.Object $warehouseId = this.getWarehouseId();
        result = result * PRIME + ($warehouseId == null ? 43 : $warehouseId.hashCode());
        final java.lang.Object $receivedBy = this.getReceivedBy();
        result = result * PRIME + ($receivedBy == null ? 43 : $receivedBy.hashCode());
        final java.lang.Object $receivedDate = this.getReceivedDate();
        result = result * PRIME + ($receivedDate == null ? 43 : $receivedDate.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "InboundReceiptRequestDTO(supplierOrderId=" + this.getSupplierOrderId() + ", warehouseId=" + this.getWarehouseId() + ", receivedDate=" + this.getReceivedDate() + ", receivedBy=" + this.getReceivedBy() + ")";
    }

    public InboundReceiptRequestDTO() {
    }

    public InboundReceiptRequestDTO(final Integer supplierOrderId, final Integer warehouseId, final LocalDate receivedDate, final Integer receivedBy) {
        this.supplierOrderId = supplierOrderId;
        this.warehouseId = warehouseId;
        this.receivedDate = receivedDate;
        this.receivedBy = receivedBy;
    }
}

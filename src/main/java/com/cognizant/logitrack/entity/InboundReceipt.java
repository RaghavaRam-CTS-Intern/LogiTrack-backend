package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.ReceiptStatus;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inbound_receipts")
public class InboundReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receiptId;
    private Integer supplierOrderId;
    private Integer warehouseId;
    private LocalDate receivedDate;
    private Integer receivedBy;
    @Enumerated(EnumType.STRING)
    private ReceiptStatus status;

    private static ReceiptStatus $default$status() {
        return ReceiptStatus.PENDING;
    }


    public static class InboundReceiptBuilder {
        private Integer receiptId;
        private Integer supplierOrderId;
        private Integer warehouseId;
        private LocalDate receivedDate;
        private Integer receivedBy;
        private boolean status$set;
        private ReceiptStatus status$value;

        InboundReceiptBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public InboundReceipt.InboundReceiptBuilder receiptId(final Integer receiptId) {
            this.receiptId = receiptId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public InboundReceipt.InboundReceiptBuilder supplierOrderId(final Integer supplierOrderId) {
            this.supplierOrderId = supplierOrderId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public InboundReceipt.InboundReceiptBuilder warehouseId(final Integer warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public InboundReceipt.InboundReceiptBuilder receivedDate(final LocalDate receivedDate) {
            this.receivedDate = receivedDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public InboundReceipt.InboundReceiptBuilder receivedBy(final Integer receivedBy) {
            this.receivedBy = receivedBy;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public InboundReceipt.InboundReceiptBuilder status(final ReceiptStatus status) {
            this.status$value = status;
            status$set = true;
            return this;
        }

        public InboundReceipt build() {
            ReceiptStatus status$value = this.status$value;
            if (!this.status$set) status$value = InboundReceipt.$default$status();
            return new InboundReceipt(this.receiptId, this.supplierOrderId, this.warehouseId, this.receivedDate, this.receivedBy, status$value);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "InboundReceipt.InboundReceiptBuilder(receiptId=" + this.receiptId + ", supplierOrderId=" + this.supplierOrderId + ", warehouseId=" + this.warehouseId + ", receivedDate=" + this.receivedDate + ", receivedBy=" + this.receivedBy + ", status$value=" + this.status$value + ")";
        }
    }

    public static InboundReceipt.InboundReceiptBuilder builder() {
        return new InboundReceipt.InboundReceiptBuilder();
    }

    public Integer getReceiptId() {
        return this.receiptId;
    }

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

    public ReceiptStatus getStatus() {
        return this.status;
    }

    public void setReceiptId(final Integer receiptId) {
        this.receiptId = receiptId;
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

    public void setStatus(final ReceiptStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof InboundReceipt)) return false;
        final InboundReceipt other = (InboundReceipt) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$receiptId = this.getReceiptId();
        final java.lang.Object other$receiptId = other.getReceiptId();
        if (this$receiptId == null ? other$receiptId != null : !this$receiptId.equals(other$receiptId)) return false;
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
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof InboundReceipt;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $receiptId = this.getReceiptId();
        result = result * PRIME + ($receiptId == null ? 43 : $receiptId.hashCode());
        final java.lang.Object $supplierOrderId = this.getSupplierOrderId();
        result = result * PRIME + ($supplierOrderId == null ? 43 : $supplierOrderId.hashCode());
        final java.lang.Object $warehouseId = this.getWarehouseId();
        result = result * PRIME + ($warehouseId == null ? 43 : $warehouseId.hashCode());
        final java.lang.Object $receivedBy = this.getReceivedBy();
        result = result * PRIME + ($receivedBy == null ? 43 : $receivedBy.hashCode());
        final java.lang.Object $receivedDate = this.getReceivedDate();
        result = result * PRIME + ($receivedDate == null ? 43 : $receivedDate.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "InboundReceipt(receiptId=" + this.getReceiptId() + ", supplierOrderId=" + this.getSupplierOrderId() + ", warehouseId=" + this.getWarehouseId() + ", receivedDate=" + this.getReceivedDate() + ", receivedBy=" + this.getReceivedBy() + ", status=" + this.getStatus() + ")";
    }

    public InboundReceipt() {
        this.status = InboundReceipt.$default$status();
    }

    public InboundReceipt(final Integer receiptId, final Integer supplierOrderId, final Integer warehouseId, final LocalDate receivedDate, final Integer receivedBy, final ReceiptStatus status) {
        this.receiptId = receiptId;
        this.supplierOrderId = supplierOrderId;
        this.warehouseId = warehouseId;
        this.receivedDate = receivedDate;
        this.receivedBy = receivedBy;
        this.status = status;
    }
}

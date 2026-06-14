package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.POStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer poId;
    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;
    private Integer warehouseId;
    @Column(columnDefinition = "TEXT")
    private String lineItems;
    private BigDecimal totalValue;
    private LocalDate orderDate;
    private LocalDate expectedDelivery;
    @Enumerated(EnumType.STRING)
    private POStatus status;

    private static POStatus $default$status() {
        return POStatus.DRAFT;
    }


    public static class PurchaseOrderBuilder {
        private Integer poId;
        private Supplier supplier;
        private Integer warehouseId;
        private String lineItems;
        private BigDecimal totalValue;
        private LocalDate orderDate;
        private LocalDate expectedDelivery;
        private boolean status$set;
        private POStatus status$value;

        PurchaseOrderBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrder.PurchaseOrderBuilder poId(final Integer poId) {
            this.poId = poId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrder.PurchaseOrderBuilder supplier(final Supplier supplier) {
            this.supplier = supplier;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrder.PurchaseOrderBuilder warehouseId(final Integer warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrder.PurchaseOrderBuilder lineItems(final String lineItems) {
            this.lineItems = lineItems;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrder.PurchaseOrderBuilder totalValue(final BigDecimal totalValue) {
            this.totalValue = totalValue;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrder.PurchaseOrderBuilder orderDate(final LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrder.PurchaseOrderBuilder expectedDelivery(final LocalDate expectedDelivery) {
            this.expectedDelivery = expectedDelivery;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrder.PurchaseOrderBuilder status(final POStatus status) {
            this.status$value = status;
            status$set = true;
            return this;
        }

        public PurchaseOrder build() {
            POStatus status$value = this.status$value;
            if (!this.status$set) status$value = PurchaseOrder.$default$status();
            return new PurchaseOrder(this.poId, this.supplier, this.warehouseId, this.lineItems, this.totalValue, this.orderDate, this.expectedDelivery, status$value);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "PurchaseOrder.PurchaseOrderBuilder(poId=" + this.poId + ", supplier=" + this.supplier + ", warehouseId=" + this.warehouseId + ", lineItems=" + this.lineItems + ", totalValue=" + this.totalValue + ", orderDate=" + this.orderDate + ", expectedDelivery=" + this.expectedDelivery + ", status$value=" + this.status$value + ")";
        }
    }

    public static PurchaseOrder.PurchaseOrderBuilder builder() {
        return new PurchaseOrder.PurchaseOrderBuilder();
    }

    public Integer getPoId() {
        return this.poId;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public Integer getWarehouseId() {
        return this.warehouseId;
    }

    public String getLineItems() {
        return this.lineItems;
    }

    public BigDecimal getTotalValue() {
        return this.totalValue;
    }

    public LocalDate getOrderDate() {
        return this.orderDate;
    }

    public LocalDate getExpectedDelivery() {
        return this.expectedDelivery;
    }

    public POStatus getStatus() {
        return this.status;
    }

    public void setPoId(final Integer poId) {
        this.poId = poId;
    }

    public void setSupplier(final Supplier supplier) {
        this.supplier = supplier;
    }

    public void setWarehouseId(final Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setLineItems(final String lineItems) {
        this.lineItems = lineItems;
    }

    public void setTotalValue(final BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public void setOrderDate(final LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setExpectedDelivery(final LocalDate expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public void setStatus(final POStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof PurchaseOrder)) return false;
        final PurchaseOrder other = (PurchaseOrder) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$poId = this.getPoId();
        final java.lang.Object other$poId = other.getPoId();
        if (this$poId == null ? other$poId != null : !this$poId.equals(other$poId)) return false;
        final java.lang.Object this$warehouseId = this.getWarehouseId();
        final java.lang.Object other$warehouseId = other.getWarehouseId();
        if (this$warehouseId == null ? other$warehouseId != null : !this$warehouseId.equals(other$warehouseId)) return false;
        final java.lang.Object this$supplier = this.getSupplier();
        final java.lang.Object other$supplier = other.getSupplier();
        if (this$supplier == null ? other$supplier != null : !this$supplier.equals(other$supplier)) return false;
        final java.lang.Object this$lineItems = this.getLineItems();
        final java.lang.Object other$lineItems = other.getLineItems();
        if (this$lineItems == null ? other$lineItems != null : !this$lineItems.equals(other$lineItems)) return false;
        final java.lang.Object this$totalValue = this.getTotalValue();
        final java.lang.Object other$totalValue = other.getTotalValue();
        if (this$totalValue == null ? other$totalValue != null : !this$totalValue.equals(other$totalValue)) return false;
        final java.lang.Object this$orderDate = this.getOrderDate();
        final java.lang.Object other$orderDate = other.getOrderDate();
        if (this$orderDate == null ? other$orderDate != null : !this$orderDate.equals(other$orderDate)) return false;
        final java.lang.Object this$expectedDelivery = this.getExpectedDelivery();
        final java.lang.Object other$expectedDelivery = other.getExpectedDelivery();
        if (this$expectedDelivery == null ? other$expectedDelivery != null : !this$expectedDelivery.equals(other$expectedDelivery)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof PurchaseOrder;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $poId = this.getPoId();
        result = result * PRIME + ($poId == null ? 43 : $poId.hashCode());
        final java.lang.Object $warehouseId = this.getWarehouseId();
        result = result * PRIME + ($warehouseId == null ? 43 : $warehouseId.hashCode());
        final java.lang.Object $supplier = this.getSupplier();
        result = result * PRIME + ($supplier == null ? 43 : $supplier.hashCode());
        final java.lang.Object $lineItems = this.getLineItems();
        result = result * PRIME + ($lineItems == null ? 43 : $lineItems.hashCode());
        final java.lang.Object $totalValue = this.getTotalValue();
        result = result * PRIME + ($totalValue == null ? 43 : $totalValue.hashCode());
        final java.lang.Object $orderDate = this.getOrderDate();
        result = result * PRIME + ($orderDate == null ? 43 : $orderDate.hashCode());
        final java.lang.Object $expectedDelivery = this.getExpectedDelivery();
        result = result * PRIME + ($expectedDelivery == null ? 43 : $expectedDelivery.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PurchaseOrder(poId=" + this.getPoId() + ", supplier=" + this.getSupplier() + ", warehouseId=" + this.getWarehouseId() + ", lineItems=" + this.getLineItems() + ", totalValue=" + this.getTotalValue() + ", orderDate=" + this.getOrderDate() + ", expectedDelivery=" + this.getExpectedDelivery() + ", status=" + this.getStatus() + ")";
    }

    public PurchaseOrder() {
        this.status = PurchaseOrder.$default$status();
    }

    public PurchaseOrder(final Integer poId, final Supplier supplier, final Integer warehouseId, final String lineItems, final BigDecimal totalValue, final LocalDate orderDate, final LocalDate expectedDelivery, final POStatus status) {
        this.poId = poId;
        this.supplier = supplier;
        this.warehouseId = warehouseId;
        this.lineItems = lineItems;
        this.totalValue = totalValue;
        this.orderDate = orderDate;
        this.expectedDelivery = expectedDelivery;
        this.status = status;
    }
}

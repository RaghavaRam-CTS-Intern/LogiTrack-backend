package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.POStatus;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseOrderDTO {
    private Integer poId;
    private Integer supplierId;
    private Integer warehouseId;
    private String lineItems;
    private BigDecimal totalValue;
    private LocalDate orderDate;
    private LocalDate expectedDelivery;
    private POStatus status;


    public static class PurchaseOrderDTOBuilder {
        private Integer poId;
        private Integer supplierId;
        private Integer warehouseId;
        private String lineItems;
        private BigDecimal totalValue;
        private LocalDate orderDate;
        private LocalDate expectedDelivery;
        private POStatus status;

        PurchaseOrderDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrderDTO.PurchaseOrderDTOBuilder poId(final Integer poId) {
            this.poId = poId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrderDTO.PurchaseOrderDTOBuilder supplierId(final Integer supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrderDTO.PurchaseOrderDTOBuilder warehouseId(final Integer warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrderDTO.PurchaseOrderDTOBuilder lineItems(final String lineItems) {
            this.lineItems = lineItems;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrderDTO.PurchaseOrderDTOBuilder totalValue(final BigDecimal totalValue) {
            this.totalValue = totalValue;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrderDTO.PurchaseOrderDTOBuilder orderDate(final LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrderDTO.PurchaseOrderDTOBuilder expectedDelivery(final LocalDate expectedDelivery) {
            this.expectedDelivery = expectedDelivery;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PurchaseOrderDTO.PurchaseOrderDTOBuilder status(final POStatus status) {
            this.status = status;
            return this;
        }

        public PurchaseOrderDTO build() {
            return new PurchaseOrderDTO(this.poId, this.supplierId, this.warehouseId, this.lineItems, this.totalValue, this.orderDate, this.expectedDelivery, this.status);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "PurchaseOrderDTO.PurchaseOrderDTOBuilder(poId=" + this.poId + ", supplierId=" + this.supplierId + ", warehouseId=" + this.warehouseId + ", lineItems=" + this.lineItems + ", totalValue=" + this.totalValue + ", orderDate=" + this.orderDate + ", expectedDelivery=" + this.expectedDelivery + ", status=" + this.status + ")";
        }
    }

    public static PurchaseOrderDTO.PurchaseOrderDTOBuilder builder() {
        return new PurchaseOrderDTO.PurchaseOrderDTOBuilder();
    }

    public Integer getPoId() {
        return this.poId;
    }

    public Integer getSupplierId() {
        return this.supplierId;
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

    public void setSupplierId(final Integer supplierId) {
        this.supplierId = supplierId;
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
        if (!(o instanceof PurchaseOrderDTO)) return false;
        final PurchaseOrderDTO other = (PurchaseOrderDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$poId = this.getPoId();
        final java.lang.Object other$poId = other.getPoId();
        if (this$poId == null ? other$poId != null : !this$poId.equals(other$poId)) return false;
        final java.lang.Object this$supplierId = this.getSupplierId();
        final java.lang.Object other$supplierId = other.getSupplierId();
        if (this$supplierId == null ? other$supplierId != null : !this$supplierId.equals(other$supplierId)) return false;
        final java.lang.Object this$warehouseId = this.getWarehouseId();
        final java.lang.Object other$warehouseId = other.getWarehouseId();
        if (this$warehouseId == null ? other$warehouseId != null : !this$warehouseId.equals(other$warehouseId)) return false;
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
        return other instanceof PurchaseOrderDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $poId = this.getPoId();
        result = result * PRIME + ($poId == null ? 43 : $poId.hashCode());
        final java.lang.Object $supplierId = this.getSupplierId();
        result = result * PRIME + ($supplierId == null ? 43 : $supplierId.hashCode());
        final java.lang.Object $warehouseId = this.getWarehouseId();
        result = result * PRIME + ($warehouseId == null ? 43 : $warehouseId.hashCode());
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
        return "PurchaseOrderDTO(poId=" + this.getPoId() + ", supplierId=" + this.getSupplierId() + ", warehouseId=" + this.getWarehouseId() + ", lineItems=" + this.getLineItems() + ", totalValue=" + this.getTotalValue() + ", orderDate=" + this.getOrderDate() + ", expectedDelivery=" + this.getExpectedDelivery() + ", status=" + this.getStatus() + ")";
    }

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(final Integer poId, final Integer supplierId, final Integer warehouseId, final String lineItems, final BigDecimal totalValue, final LocalDate orderDate, final LocalDate expectedDelivery, final POStatus status) {
        this.poId = poId;
        this.supplierId = supplierId;
        this.warehouseId = warehouseId;
        this.lineItems = lineItems;
        this.totalValue = totalValue;
        this.orderDate = orderDate;
        this.expectedDelivery = expectedDelivery;
        this.status = status;
    }
}

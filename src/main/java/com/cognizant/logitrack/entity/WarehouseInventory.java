package com.cognizant.logitrack.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "warehouse_inventory")
public class WarehouseInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;
    @Column(length = 50)
    private String sku;
    private String productName;
    private Integer warehouseId;
    private String binLocation;
    private Integer quantityOnHand;
    private Integer quantityReserved;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;


    public static class WarehouseInventoryBuilder {
        private Integer inventoryId;
        private String sku;
        private String productName;
        private Integer warehouseId;
        private String binLocation;
        private Integer quantityOnHand;
        private Integer quantityReserved;
        private LocalDateTime lastUpdated;

        WarehouseInventoryBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public WarehouseInventory.WarehouseInventoryBuilder inventoryId(final Integer inventoryId) {
            this.inventoryId = inventoryId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public WarehouseInventory.WarehouseInventoryBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public WarehouseInventory.WarehouseInventoryBuilder productName(final String productName) {
            this.productName = productName;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public WarehouseInventory.WarehouseInventoryBuilder warehouseId(final Integer warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public WarehouseInventory.WarehouseInventoryBuilder binLocation(final String binLocation) {
            this.binLocation = binLocation;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public WarehouseInventory.WarehouseInventoryBuilder quantityOnHand(final Integer quantityOnHand) {
            this.quantityOnHand = quantityOnHand;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public WarehouseInventory.WarehouseInventoryBuilder quantityReserved(final Integer quantityReserved) {
            this.quantityReserved = quantityReserved;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public WarehouseInventory.WarehouseInventoryBuilder lastUpdated(final LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public WarehouseInventory build() {
            return new WarehouseInventory(this.inventoryId, this.sku, this.productName, this.warehouseId, this.binLocation, this.quantityOnHand, this.quantityReserved, this.lastUpdated);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "WarehouseInventory.WarehouseInventoryBuilder(inventoryId=" + this.inventoryId + ", sku=" + this.sku + ", productName=" + this.productName + ", warehouseId=" + this.warehouseId + ", binLocation=" + this.binLocation + ", quantityOnHand=" + this.quantityOnHand + ", quantityReserved=" + this.quantityReserved + ", lastUpdated=" + this.lastUpdated + ")";
        }
    }

    public static WarehouseInventory.WarehouseInventoryBuilder builder() {
        return new WarehouseInventory.WarehouseInventoryBuilder();
    }

    public Integer getInventoryId() {
        return this.inventoryId;
    }

    public String getSku() {
        return this.sku;
    }

    public String getProductName() {
        return this.productName;
    }

    public Integer getWarehouseId() {
        return this.warehouseId;
    }

    public String getBinLocation() {
        return this.binLocation;
    }

    public Integer getQuantityOnHand() {
        return this.quantityOnHand;
    }

    public Integer getQuantityReserved() {
        return this.quantityReserved;
    }

    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    public void setInventoryId(final Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public void setWarehouseId(final Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setBinLocation(final String binLocation) {
        this.binLocation = binLocation;
    }

    public void setQuantityOnHand(final Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public void setQuantityReserved(final Integer quantityReserved) {
        this.quantityReserved = quantityReserved;
    }

    public void setLastUpdated(final LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof WarehouseInventory)) return false;
        final WarehouseInventory other = (WarehouseInventory) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$inventoryId = this.getInventoryId();
        final java.lang.Object other$inventoryId = other.getInventoryId();
        if (this$inventoryId == null ? other$inventoryId != null : !this$inventoryId.equals(other$inventoryId)) return false;
        final java.lang.Object this$warehouseId = this.getWarehouseId();
        final java.lang.Object other$warehouseId = other.getWarehouseId();
        if (this$warehouseId == null ? other$warehouseId != null : !this$warehouseId.equals(other$warehouseId)) return false;
        final java.lang.Object this$quantityOnHand = this.getQuantityOnHand();
        final java.lang.Object other$quantityOnHand = other.getQuantityOnHand();
        if (this$quantityOnHand == null ? other$quantityOnHand != null : !this$quantityOnHand.equals(other$quantityOnHand)) return false;
        final java.lang.Object this$quantityReserved = this.getQuantityReserved();
        final java.lang.Object other$quantityReserved = other.getQuantityReserved();
        if (this$quantityReserved == null ? other$quantityReserved != null : !this$quantityReserved.equals(other$quantityReserved)) return false;
        final java.lang.Object this$sku = this.getSku();
        final java.lang.Object other$sku = other.getSku();
        if (this$sku == null ? other$sku != null : !this$sku.equals(other$sku)) return false;
        final java.lang.Object this$productName = this.getProductName();
        final java.lang.Object other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName)) return false;
        final java.lang.Object this$binLocation = this.getBinLocation();
        final java.lang.Object other$binLocation = other.getBinLocation();
        if (this$binLocation == null ? other$binLocation != null : !this$binLocation.equals(other$binLocation)) return false;
        final java.lang.Object this$lastUpdated = this.getLastUpdated();
        final java.lang.Object other$lastUpdated = other.getLastUpdated();
        if (this$lastUpdated == null ? other$lastUpdated != null : !this$lastUpdated.equals(other$lastUpdated)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof WarehouseInventory;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $inventoryId = this.getInventoryId();
        result = result * PRIME + ($inventoryId == null ? 43 : $inventoryId.hashCode());
        final java.lang.Object $warehouseId = this.getWarehouseId();
        result = result * PRIME + ($warehouseId == null ? 43 : $warehouseId.hashCode());
        final java.lang.Object $quantityOnHand = this.getQuantityOnHand();
        result = result * PRIME + ($quantityOnHand == null ? 43 : $quantityOnHand.hashCode());
        final java.lang.Object $quantityReserved = this.getQuantityReserved();
        result = result * PRIME + ($quantityReserved == null ? 43 : $quantityReserved.hashCode());
        final java.lang.Object $sku = this.getSku();
        result = result * PRIME + ($sku == null ? 43 : $sku.hashCode());
        final java.lang.Object $productName = this.getProductName();
        result = result * PRIME + ($productName == null ? 43 : $productName.hashCode());
        final java.lang.Object $binLocation = this.getBinLocation();
        result = result * PRIME + ($binLocation == null ? 43 : $binLocation.hashCode());
        final java.lang.Object $lastUpdated = this.getLastUpdated();
        result = result * PRIME + ($lastUpdated == null ? 43 : $lastUpdated.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "WarehouseInventory(inventoryId=" + this.getInventoryId() + ", sku=" + this.getSku() + ", productName=" + this.getProductName() + ", warehouseId=" + this.getWarehouseId() + ", binLocation=" + this.getBinLocation() + ", quantityOnHand=" + this.getQuantityOnHand() + ", quantityReserved=" + this.getQuantityReserved() + ", lastUpdated=" + this.getLastUpdated() + ")";
    }

    public WarehouseInventory() {
    }

    public WarehouseInventory(final Integer inventoryId, final String sku, final String productName, final Integer warehouseId, final String binLocation, final Integer quantityOnHand, final Integer quantityReserved, final LocalDateTime lastUpdated) {
        this.inventoryId = inventoryId;
        this.sku = sku;
        this.productName = productName;
        this.warehouseId = warehouseId;
        this.binLocation = binLocation;
        this.quantityOnHand = quantityOnHand;
        this.quantityReserved = quantityReserved;
        this.lastUpdated = lastUpdated;
    }
}

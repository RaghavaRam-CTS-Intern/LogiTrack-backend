package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.PickListStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;

@Entity
@Table(name = "pick_lists")
public class PickList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pickListId;
    private Integer freightOrderId;
    private Integer warehouseId;
    private Integer assignedTo;
    @Enumerated(EnumType.STRING)
    private PickListStatus status;
    @CreationTimestamp
    private LocalDate createdDate;

    private static PickListStatus $default$status() {
        return PickListStatus.OPEN;
    }


    public static class PickListBuilder {
        private Integer pickListId;
        private Integer freightOrderId;
        private Integer warehouseId;
        private Integer assignedTo;
        private boolean status$set;
        private PickListStatus status$value;
        private LocalDate createdDate;

        PickListBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public PickList.PickListBuilder pickListId(final Integer pickListId) {
            this.pickListId = pickListId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickList.PickListBuilder freightOrderId(final Integer freightOrderId) {
            this.freightOrderId = freightOrderId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickList.PickListBuilder warehouseId(final Integer warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickList.PickListBuilder assignedTo(final Integer assignedTo) {
            this.assignedTo = assignedTo;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickList.PickListBuilder status(final PickListStatus status) {
            this.status$value = status;
            status$set = true;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickList.PickListBuilder createdDate(final LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public PickList build() {
            PickListStatus status$value = this.status$value;
            if (!this.status$set) status$value = PickList.$default$status();
            return new PickList(this.pickListId, this.freightOrderId, this.warehouseId, this.assignedTo, status$value, this.createdDate);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "PickList.PickListBuilder(pickListId=" + this.pickListId + ", freightOrderId=" + this.freightOrderId + ", warehouseId=" + this.warehouseId + ", assignedTo=" + this.assignedTo + ", status$value=" + this.status$value + ", createdDate=" + this.createdDate + ")";
        }
    }

    public static PickList.PickListBuilder builder() {
        return new PickList.PickListBuilder();
    }

    public Integer getPickListId() {
        return this.pickListId;
    }

    public Integer getFreightOrderId() {
        return this.freightOrderId;
    }

    public Integer getWarehouseId() {
        return this.warehouseId;
    }

    public Integer getAssignedTo() {
        return this.assignedTo;
    }

    public PickListStatus getStatus() {
        return this.status;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public void setPickListId(final Integer pickListId) {
        this.pickListId = pickListId;
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

    public void setStatus(final PickListStatus status) {
        this.status = status;
    }

    public void setCreatedDate(final LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof PickList)) return false;
        final PickList other = (PickList) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$pickListId = this.getPickListId();
        final java.lang.Object other$pickListId = other.getPickListId();
        if (this$pickListId == null ? other$pickListId != null : !this$pickListId.equals(other$pickListId)) return false;
        final java.lang.Object this$freightOrderId = this.getFreightOrderId();
        final java.lang.Object other$freightOrderId = other.getFreightOrderId();
        if (this$freightOrderId == null ? other$freightOrderId != null : !this$freightOrderId.equals(other$freightOrderId)) return false;
        final java.lang.Object this$warehouseId = this.getWarehouseId();
        final java.lang.Object other$warehouseId = other.getWarehouseId();
        if (this$warehouseId == null ? other$warehouseId != null : !this$warehouseId.equals(other$warehouseId)) return false;
        final java.lang.Object this$assignedTo = this.getAssignedTo();
        final java.lang.Object other$assignedTo = other.getAssignedTo();
        if (this$assignedTo == null ? other$assignedTo != null : !this$assignedTo.equals(other$assignedTo)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final java.lang.Object this$createdDate = this.getCreatedDate();
        final java.lang.Object other$createdDate = other.getCreatedDate();
        if (this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof PickList;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $pickListId = this.getPickListId();
        result = result * PRIME + ($pickListId == null ? 43 : $pickListId.hashCode());
        final java.lang.Object $freightOrderId = this.getFreightOrderId();
        result = result * PRIME + ($freightOrderId == null ? 43 : $freightOrderId.hashCode());
        final java.lang.Object $warehouseId = this.getWarehouseId();
        result = result * PRIME + ($warehouseId == null ? 43 : $warehouseId.hashCode());
        final java.lang.Object $assignedTo = this.getAssignedTo();
        result = result * PRIME + ($assignedTo == null ? 43 : $assignedTo.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final java.lang.Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PickList(pickListId=" + this.getPickListId() + ", freightOrderId=" + this.getFreightOrderId() + ", warehouseId=" + this.getWarehouseId() + ", assignedTo=" + this.getAssignedTo() + ", status=" + this.getStatus() + ", createdDate=" + this.getCreatedDate() + ")";
    }

    public PickList() {
        this.status = PickList.$default$status();
    }

    public PickList(final Integer pickListId, final Integer freightOrderId, final Integer warehouseId, final Integer assignedTo, final PickListStatus status, final LocalDate createdDate) {
        this.pickListId = pickListId;
        this.freightOrderId = freightOrderId;
        this.warehouseId = warehouseId;
        this.assignedTo = assignedTo;
        this.status = status;
        this.createdDate = createdDate;
    }
}

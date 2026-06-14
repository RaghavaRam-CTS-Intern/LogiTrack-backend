package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.PickListStatus;
import java.time.LocalDate;

public class PickListDTO {
    private Integer pickListId;
    private Integer freightOrderId;
    private Integer warehouseId;
    private Integer assignedTo;
    private PickListStatus status;
    private LocalDate createdDate;


    public static class PickListDTOBuilder {
        private Integer pickListId;
        private Integer freightOrderId;
        private Integer warehouseId;
        private Integer assignedTo;
        private PickListStatus status;
        private LocalDate createdDate;

        PickListDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public PickListDTO.PickListDTOBuilder pickListId(final Integer pickListId) {
            this.pickListId = pickListId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickListDTO.PickListDTOBuilder freightOrderId(final Integer freightOrderId) {
            this.freightOrderId = freightOrderId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickListDTO.PickListDTOBuilder warehouseId(final Integer warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickListDTO.PickListDTOBuilder assignedTo(final Integer assignedTo) {
            this.assignedTo = assignedTo;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickListDTO.PickListDTOBuilder status(final PickListStatus status) {
            this.status = status;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public PickListDTO.PickListDTOBuilder createdDate(final LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public PickListDTO build() {
            return new PickListDTO(this.pickListId, this.freightOrderId, this.warehouseId, this.assignedTo, this.status, this.createdDate);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "PickListDTO.PickListDTOBuilder(pickListId=" + this.pickListId + ", freightOrderId=" + this.freightOrderId + ", warehouseId=" + this.warehouseId + ", assignedTo=" + this.assignedTo + ", status=" + this.status + ", createdDate=" + this.createdDate + ")";
        }
    }

    public static PickListDTO.PickListDTOBuilder builder() {
        return new PickListDTO.PickListDTOBuilder();
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
        if (!(o instanceof PickListDTO)) return false;
        final PickListDTO other = (PickListDTO) o;
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
        return other instanceof PickListDTO;
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
        return "PickListDTO(pickListId=" + this.getPickListId() + ", freightOrderId=" + this.getFreightOrderId() + ", warehouseId=" + this.getWarehouseId() + ", assignedTo=" + this.getAssignedTo() + ", status=" + this.getStatus() + ", createdDate=" + this.getCreatedDate() + ")";
    }

    public PickListDTO() {
    }

    public PickListDTO(final Integer pickListId, final Integer freightOrderId, final Integer warehouseId, final Integer assignedTo, final PickListStatus status, final LocalDate createdDate) {
        this.pickListId = pickListId;
        this.freightOrderId = freightOrderId;
        this.warehouseId = warehouseId;
        this.assignedTo = assignedTo;
        this.status = status;
        this.createdDate = createdDate;
    }
}

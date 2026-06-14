package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.SupplierStatus;

public class SupplierDTO {
    private Integer supplierId;
    private String name;
    private String category;
    private String contactDetails;
    private Integer leadTimeDays;
    private SupplierStatus status;


    public static class SupplierDTOBuilder {
        private Integer supplierId;
        private String name;
        private String category;
        private String contactDetails;
        private Integer leadTimeDays;
        private SupplierStatus status;

        SupplierDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public SupplierDTO.SupplierDTOBuilder supplierId(final Integer supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public SupplierDTO.SupplierDTOBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public SupplierDTO.SupplierDTOBuilder category(final String category) {
            this.category = category;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public SupplierDTO.SupplierDTOBuilder contactDetails(final String contactDetails) {
            this.contactDetails = contactDetails;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public SupplierDTO.SupplierDTOBuilder leadTimeDays(final Integer leadTimeDays) {
            this.leadTimeDays = leadTimeDays;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public SupplierDTO.SupplierDTOBuilder status(final SupplierStatus status) {
            this.status = status;
            return this;
        }

        public SupplierDTO build() {
            return new SupplierDTO(this.supplierId, this.name, this.category, this.contactDetails, this.leadTimeDays, this.status);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "SupplierDTO.SupplierDTOBuilder(supplierId=" + this.supplierId + ", name=" + this.name + ", category=" + this.category + ", contactDetails=" + this.contactDetails + ", leadTimeDays=" + this.leadTimeDays + ", status=" + this.status + ")";
        }
    }

    public static SupplierDTO.SupplierDTOBuilder builder() {
        return new SupplierDTO.SupplierDTOBuilder();
    }

    public Integer getSupplierId() {
        return this.supplierId;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getContactDetails() {
        return this.contactDetails;
    }

    public Integer getLeadTimeDays() {
        return this.leadTimeDays;
    }

    public SupplierStatus getStatus() {
        return this.status;
    }

    public void setSupplierId(final Integer supplierId) {
        this.supplierId = supplierId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public void setContactDetails(final String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setLeadTimeDays(final Integer leadTimeDays) {
        this.leadTimeDays = leadTimeDays;
    }

    public void setStatus(final SupplierStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof SupplierDTO)) return false;
        final SupplierDTO other = (SupplierDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$supplierId = this.getSupplierId();
        final java.lang.Object other$supplierId = other.getSupplierId();
        if (this$supplierId == null ? other$supplierId != null : !this$supplierId.equals(other$supplierId)) return false;
        final java.lang.Object this$leadTimeDays = this.getLeadTimeDays();
        final java.lang.Object other$leadTimeDays = other.getLeadTimeDays();
        if (this$leadTimeDays == null ? other$leadTimeDays != null : !this$leadTimeDays.equals(other$leadTimeDays)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$category = this.getCategory();
        final java.lang.Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category)) return false;
        final java.lang.Object this$contactDetails = this.getContactDetails();
        final java.lang.Object other$contactDetails = other.getContactDetails();
        if (this$contactDetails == null ? other$contactDetails != null : !this$contactDetails.equals(other$contactDetails)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof SupplierDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $supplierId = this.getSupplierId();
        result = result * PRIME + ($supplierId == null ? 43 : $supplierId.hashCode());
        final java.lang.Object $leadTimeDays = this.getLeadTimeDays();
        result = result * PRIME + ($leadTimeDays == null ? 43 : $leadTimeDays.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final java.lang.Object $contactDetails = this.getContactDetails();
        result = result * PRIME + ($contactDetails == null ? 43 : $contactDetails.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SupplierDTO(supplierId=" + this.getSupplierId() + ", name=" + this.getName() + ", category=" + this.getCategory() + ", contactDetails=" + this.getContactDetails() + ", leadTimeDays=" + this.getLeadTimeDays() + ", status=" + this.getStatus() + ")";
    }

    public SupplierDTO() {
    }

    public SupplierDTO(final Integer supplierId, final String name, final String category, final String contactDetails, final Integer leadTimeDays, final SupplierStatus status) {
        this.supplierId = supplierId;
        this.name = name;
        this.category = category;
        this.contactDetails = contactDetails;
        this.leadTimeDays = leadTimeDays;
        this.status = status;
    }
}

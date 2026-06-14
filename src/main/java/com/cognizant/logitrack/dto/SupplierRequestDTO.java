package com.cognizant.logitrack.dto;

import jakarta.validation.constraints.NotBlank;

public class SupplierRequestDTO {
    @NotBlank
    private String name;
    private String category;
    private String contactDetails;
    private Integer leadTimeDays;

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

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof SupplierRequestDTO)) return false;
        final SupplierRequestDTO other = (SupplierRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
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
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof SupplierRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $leadTimeDays = this.getLeadTimeDays();
        result = result * PRIME + ($leadTimeDays == null ? 43 : $leadTimeDays.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final java.lang.Object $contactDetails = this.getContactDetails();
        result = result * PRIME + ($contactDetails == null ? 43 : $contactDetails.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SupplierRequestDTO(name=" + this.getName() + ", category=" + this.getCategory() + ", contactDetails=" + this.getContactDetails() + ", leadTimeDays=" + this.getLeadTimeDays() + ")";
    }

    public SupplierRequestDTO() {
    }

    public SupplierRequestDTO(final String name, final String category, final String contactDetails, final Integer leadTimeDays) {
        this.name = name;
        this.category = category;
        this.contactDetails = contactDetails;
        this.leadTimeDays = leadTimeDays;
    }
}

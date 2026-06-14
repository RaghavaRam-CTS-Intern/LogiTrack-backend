package com.cognizant.logitrack.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RateCardRequestDTO {
    @NotNull
    private Integer carrierId;
    @NotNull
    private Integer routeId;
    @NotNull
    private BigDecimal baseRate;
    private String weightSlab;
    private LocalDate effectiveDate;
    private LocalDate expiryDate;

    public Integer getCarrierId() {
        return this.carrierId;
    }

    public Integer getRouteId() {
        return this.routeId;
    }

    public BigDecimal getBaseRate() {
        return this.baseRate;
    }

    public String getWeightSlab() {
        return this.weightSlab;
    }

    public LocalDate getEffectiveDate() {
        return this.effectiveDate;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public void setCarrierId(final Integer carrierId) {
        this.carrierId = carrierId;
    }

    public void setRouteId(final Integer routeId) {
        this.routeId = routeId;
    }

    public void setBaseRate(final BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public void setWeightSlab(final String weightSlab) {
        this.weightSlab = weightSlab;
    }

    public void setEffectiveDate(final LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setExpiryDate(final LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof RateCardRequestDTO)) return false;
        final RateCardRequestDTO other = (RateCardRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$carrierId = this.getCarrierId();
        final java.lang.Object other$carrierId = other.getCarrierId();
        if (this$carrierId == null ? other$carrierId != null : !this$carrierId.equals(other$carrierId)) return false;
        final java.lang.Object this$routeId = this.getRouteId();
        final java.lang.Object other$routeId = other.getRouteId();
        if (this$routeId == null ? other$routeId != null : !this$routeId.equals(other$routeId)) return false;
        final java.lang.Object this$baseRate = this.getBaseRate();
        final java.lang.Object other$baseRate = other.getBaseRate();
        if (this$baseRate == null ? other$baseRate != null : !this$baseRate.equals(other$baseRate)) return false;
        final java.lang.Object this$weightSlab = this.getWeightSlab();
        final java.lang.Object other$weightSlab = other.getWeightSlab();
        if (this$weightSlab == null ? other$weightSlab != null : !this$weightSlab.equals(other$weightSlab)) return false;
        final java.lang.Object this$effectiveDate = this.getEffectiveDate();
        final java.lang.Object other$effectiveDate = other.getEffectiveDate();
        if (this$effectiveDate == null ? other$effectiveDate != null : !this$effectiveDate.equals(other$effectiveDate)) return false;
        final java.lang.Object this$expiryDate = this.getExpiryDate();
        final java.lang.Object other$expiryDate = other.getExpiryDate();
        if (this$expiryDate == null ? other$expiryDate != null : !this$expiryDate.equals(other$expiryDate)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof RateCardRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $carrierId = this.getCarrierId();
        result = result * PRIME + ($carrierId == null ? 43 : $carrierId.hashCode());
        final java.lang.Object $routeId = this.getRouteId();
        result = result * PRIME + ($routeId == null ? 43 : $routeId.hashCode());
        final java.lang.Object $baseRate = this.getBaseRate();
        result = result * PRIME + ($baseRate == null ? 43 : $baseRate.hashCode());
        final java.lang.Object $weightSlab = this.getWeightSlab();
        result = result * PRIME + ($weightSlab == null ? 43 : $weightSlab.hashCode());
        final java.lang.Object $effectiveDate = this.getEffectiveDate();
        result = result * PRIME + ($effectiveDate == null ? 43 : $effectiveDate.hashCode());
        final java.lang.Object $expiryDate = this.getExpiryDate();
        result = result * PRIME + ($expiryDate == null ? 43 : $expiryDate.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RateCardRequestDTO(carrierId=" + this.getCarrierId() + ", routeId=" + this.getRouteId() + ", baseRate=" + this.getBaseRate() + ", weightSlab=" + this.getWeightSlab() + ", effectiveDate=" + this.getEffectiveDate() + ", expiryDate=" + this.getExpiryDate() + ")";
    }

    public RateCardRequestDTO() {
    }

    public RateCardRequestDTO(final Integer carrierId, final Integer routeId, final BigDecimal baseRate, final String weightSlab, final LocalDate effectiveDate, final LocalDate expiryDate) {
        this.carrierId = carrierId;
        this.routeId = routeId;
        this.baseRate = baseRate;
        this.weightSlab = weightSlab;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
    }
}

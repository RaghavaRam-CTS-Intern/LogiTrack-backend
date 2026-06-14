package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.RateCardStatus;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RateCardDTO {
    private Integer rateCardId;
    private Integer carrierId;
    private Integer routeId;
    private BigDecimal baseRate;
    private String weightSlab;
    private LocalDate effectiveDate;
    private LocalDate expiryDate;
    private RateCardStatus status;


    public static class RateCardDTOBuilder {
        private Integer rateCardId;
        private Integer carrierId;
        private Integer routeId;
        private BigDecimal baseRate;
        private String weightSlab;
        private LocalDate effectiveDate;
        private LocalDate expiryDate;
        private RateCardStatus status;

        RateCardDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public RateCardDTO.RateCardDTOBuilder rateCardId(final Integer rateCardId) {
            this.rateCardId = rateCardId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCardDTO.RateCardDTOBuilder carrierId(final Integer carrierId) {
            this.carrierId = carrierId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCardDTO.RateCardDTOBuilder routeId(final Integer routeId) {
            this.routeId = routeId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCardDTO.RateCardDTOBuilder baseRate(final BigDecimal baseRate) {
            this.baseRate = baseRate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCardDTO.RateCardDTOBuilder weightSlab(final String weightSlab) {
            this.weightSlab = weightSlab;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCardDTO.RateCardDTOBuilder effectiveDate(final LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCardDTO.RateCardDTOBuilder expiryDate(final LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCardDTO.RateCardDTOBuilder status(final RateCardStatus status) {
            this.status = status;
            return this;
        }

        public RateCardDTO build() {
            return new RateCardDTO(this.rateCardId, this.carrierId, this.routeId, this.baseRate, this.weightSlab, this.effectiveDate, this.expiryDate, this.status);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "RateCardDTO.RateCardDTOBuilder(rateCardId=" + this.rateCardId + ", carrierId=" + this.carrierId + ", routeId=" + this.routeId + ", baseRate=" + this.baseRate + ", weightSlab=" + this.weightSlab + ", effectiveDate=" + this.effectiveDate + ", expiryDate=" + this.expiryDate + ", status=" + this.status + ")";
        }
    }

    public static RateCardDTO.RateCardDTOBuilder builder() {
        return new RateCardDTO.RateCardDTOBuilder();
    }

    public Integer getRateCardId() {
        return this.rateCardId;
    }

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

    public RateCardStatus getStatus() {
        return this.status;
    }

    public void setRateCardId(final Integer rateCardId) {
        this.rateCardId = rateCardId;
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

    public void setStatus(final RateCardStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof RateCardDTO)) return false;
        final RateCardDTO other = (RateCardDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$rateCardId = this.getRateCardId();
        final java.lang.Object other$rateCardId = other.getRateCardId();
        if (this$rateCardId == null ? other$rateCardId != null : !this$rateCardId.equals(other$rateCardId)) return false;
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
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof RateCardDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $rateCardId = this.getRateCardId();
        result = result * PRIME + ($rateCardId == null ? 43 : $rateCardId.hashCode());
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
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RateCardDTO(rateCardId=" + this.getRateCardId() + ", carrierId=" + this.getCarrierId() + ", routeId=" + this.getRouteId() + ", baseRate=" + this.getBaseRate() + ", weightSlab=" + this.getWeightSlab() + ", effectiveDate=" + this.getEffectiveDate() + ", expiryDate=" + this.getExpiryDate() + ", status=" + this.getStatus() + ")";
    }

    public RateCardDTO() {
    }

    public RateCardDTO(final Integer rateCardId, final Integer carrierId, final Integer routeId, final BigDecimal baseRate, final String weightSlab, final LocalDate effectiveDate, final LocalDate expiryDate, final RateCardStatus status) {
        this.rateCardId = rateCardId;
        this.carrierId = carrierId;
        this.routeId = routeId;
        this.baseRate = baseRate;
        this.weightSlab = weightSlab;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }
}

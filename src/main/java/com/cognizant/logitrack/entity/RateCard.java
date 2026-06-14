package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.RateCardStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "rate_cards")
public class RateCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rateCardId;
    @ManyToOne
    @JoinColumn(name = "CarrierID")
    private Carrier carrier;
    @ManyToOne
    @JoinColumn(name = "RouteID")
    private Route route;
    private BigDecimal baseRate;
    @Column(length = 100)
    private String weightSlab;
    private LocalDate effectiveDate;
    private LocalDate expiryDate;
    @Enumerated(EnumType.STRING)
    private RateCardStatus status;

    private static RateCardStatus $default$status() {
        return RateCardStatus.ACTIVE;
    }


    public static class RateCardBuilder {
        private Integer rateCardId;
        private Carrier carrier;
        private Route route;
        private BigDecimal baseRate;
        private String weightSlab;
        private LocalDate effectiveDate;
        private LocalDate expiryDate;
        private boolean status$set;
        private RateCardStatus status$value;

        RateCardBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public RateCard.RateCardBuilder rateCardId(final Integer rateCardId) {
            this.rateCardId = rateCardId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCard.RateCardBuilder carrier(final Carrier carrier) {
            this.carrier = carrier;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCard.RateCardBuilder route(final Route route) {
            this.route = route;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCard.RateCardBuilder baseRate(final BigDecimal baseRate) {
            this.baseRate = baseRate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCard.RateCardBuilder weightSlab(final String weightSlab) {
            this.weightSlab = weightSlab;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCard.RateCardBuilder effectiveDate(final LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCard.RateCardBuilder expiryDate(final LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public RateCard.RateCardBuilder status(final RateCardStatus status) {
            this.status$value = status;
            status$set = true;
            return this;
        }

        public RateCard build() {
            RateCardStatus status$value = this.status$value;
            if (!this.status$set) status$value = RateCard.$default$status();
            return new RateCard(this.rateCardId, this.carrier, this.route, this.baseRate, this.weightSlab, this.effectiveDate, this.expiryDate, status$value);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "RateCard.RateCardBuilder(rateCardId=" + this.rateCardId + ", carrier=" + this.carrier + ", route=" + this.route + ", baseRate=" + this.baseRate + ", weightSlab=" + this.weightSlab + ", effectiveDate=" + this.effectiveDate + ", expiryDate=" + this.expiryDate + ", status$value=" + this.status$value + ")";
        }
    }

    public static RateCard.RateCardBuilder builder() {
        return new RateCard.RateCardBuilder();
    }

    public Integer getRateCardId() {
        return this.rateCardId;
    }

    public Carrier getCarrier() {
        return this.carrier;
    }

    public Route getRoute() {
        return this.route;
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

    public void setCarrier(final Carrier carrier) {
        this.carrier = carrier;
    }

    public void setRoute(final Route route) {
        this.route = route;
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
        if (!(o instanceof RateCard)) return false;
        final RateCard other = (RateCard) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$rateCardId = this.getRateCardId();
        final java.lang.Object other$rateCardId = other.getRateCardId();
        if (this$rateCardId == null ? other$rateCardId != null : !this$rateCardId.equals(other$rateCardId)) return false;
        final java.lang.Object this$carrier = this.getCarrier();
        final java.lang.Object other$carrier = other.getCarrier();
        if (this$carrier == null ? other$carrier != null : !this$carrier.equals(other$carrier)) return false;
        final java.lang.Object this$route = this.getRoute();
        final java.lang.Object other$route = other.getRoute();
        if (this$route == null ? other$route != null : !this$route.equals(other$route)) return false;
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
        return other instanceof RateCard;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $rateCardId = this.getRateCardId();
        result = result * PRIME + ($rateCardId == null ? 43 : $rateCardId.hashCode());
        final java.lang.Object $carrier = this.getCarrier();
        result = result * PRIME + ($carrier == null ? 43 : $carrier.hashCode());
        final java.lang.Object $route = this.getRoute();
        result = result * PRIME + ($route == null ? 43 : $route.hashCode());
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
        return "RateCard(rateCardId=" + this.getRateCardId() + ", carrier=" + this.getCarrier() + ", route=" + this.getRoute() + ", baseRate=" + this.getBaseRate() + ", weightSlab=" + this.getWeightSlab() + ", effectiveDate=" + this.getEffectiveDate() + ", expiryDate=" + this.getExpiryDate() + ", status=" + this.getStatus() + ")";
    }

    public RateCard() {
        this.status = RateCard.$default$status();
    }

    public RateCard(final Integer rateCardId, final Carrier carrier, final Route route, final BigDecimal baseRate, final String weightSlab, final LocalDate effectiveDate, final LocalDate expiryDate, final RateCardStatus status) {
        this.rateCardId = rateCardId;
        this.carrier = carrier;
        this.route = route;
        this.baseRate = baseRate;
        this.weightSlab = weightSlab;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }
}

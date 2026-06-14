package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.FreightOrderStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "freight_orders")
public class FreightOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer freightOrderId;
    private Integer shipperId;
    private Integer originLocationId;
    private Integer destinationLocationId;
    private String cargoDescription;
    private BigDecimal weight;
    private BigDecimal volume;
    private LocalDate requiredDeliveryDate;
    @Enumerated(EnumType.STRING)
    private FreightOrderStatus status;

    private static FreightOrderStatus $default$status() {
        return FreightOrderStatus.DRAFT;
    }


    public static class FreightOrderBuilder {
        private Integer freightOrderId;
        private Integer shipperId;
        private Integer originLocationId;
        private Integer destinationLocationId;
        private String cargoDescription;
        private BigDecimal weight;
        private BigDecimal volume;
        private LocalDate requiredDeliveryDate;
        private boolean status$set;
        private FreightOrderStatus status$value;

        FreightOrderBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public FreightOrder.FreightOrderBuilder freightOrderId(final Integer freightOrderId) {
            this.freightOrderId = freightOrderId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public FreightOrder.FreightOrderBuilder shipperId(final Integer shipperId) {
            this.shipperId = shipperId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public FreightOrder.FreightOrderBuilder originLocationId(final Integer originLocationId) {
            this.originLocationId = originLocationId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public FreightOrder.FreightOrderBuilder destinationLocationId(final Integer destinationLocationId) {
            this.destinationLocationId = destinationLocationId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public FreightOrder.FreightOrderBuilder cargoDescription(final String cargoDescription) {
            this.cargoDescription = cargoDescription;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public FreightOrder.FreightOrderBuilder weight(final BigDecimal weight) {
            this.weight = weight;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public FreightOrder.FreightOrderBuilder volume(final BigDecimal volume) {
            this.volume = volume;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public FreightOrder.FreightOrderBuilder requiredDeliveryDate(final LocalDate requiredDeliveryDate) {
            this.requiredDeliveryDate = requiredDeliveryDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public FreightOrder.FreightOrderBuilder status(final FreightOrderStatus status) {
            this.status$value = status;
            status$set = true;
            return this;
        }

        public FreightOrder build() {
            FreightOrderStatus status$value = this.status$value;
            if (!this.status$set) status$value = FreightOrder.$default$status();
            return new FreightOrder(this.freightOrderId, this.shipperId, this.originLocationId, this.destinationLocationId, this.cargoDescription, this.weight, this.volume, this.requiredDeliveryDate, status$value);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "FreightOrder.FreightOrderBuilder(freightOrderId=" + this.freightOrderId + ", shipperId=" + this.shipperId + ", originLocationId=" + this.originLocationId + ", destinationLocationId=" + this.destinationLocationId + ", cargoDescription=" + this.cargoDescription + ", weight=" + this.weight + ", volume=" + this.volume + ", requiredDeliveryDate=" + this.requiredDeliveryDate + ", status$value=" + this.status$value + ")";
        }
    }

    public static FreightOrder.FreightOrderBuilder builder() {
        return new FreightOrder.FreightOrderBuilder();
    }

    public Integer getFreightOrderId() {
        return this.freightOrderId;
    }

    public Integer getShipperId() {
        return this.shipperId;
    }

    public Integer getOriginLocationId() {
        return this.originLocationId;
    }

    public Integer getDestinationLocationId() {
        return this.destinationLocationId;
    }

    public String getCargoDescription() {
        return this.cargoDescription;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public BigDecimal getVolume() {
        return this.volume;
    }

    public LocalDate getRequiredDeliveryDate() {
        return this.requiredDeliveryDate;
    }

    public FreightOrderStatus getStatus() {
        return this.status;
    }

    public void setFreightOrderId(final Integer freightOrderId) {
        this.freightOrderId = freightOrderId;
    }

    public void setShipperId(final Integer shipperId) {
        this.shipperId = shipperId;
    }

    public void setOriginLocationId(final Integer originLocationId) {
        this.originLocationId = originLocationId;
    }

    public void setDestinationLocationId(final Integer destinationLocationId) {
        this.destinationLocationId = destinationLocationId;
    }

    public void setCargoDescription(final String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public void setWeight(final BigDecimal weight) {
        this.weight = weight;
    }

    public void setVolume(final BigDecimal volume) {
        this.volume = volume;
    }

    public void setRequiredDeliveryDate(final LocalDate requiredDeliveryDate) {
        this.requiredDeliveryDate = requiredDeliveryDate;
    }

    public void setStatus(final FreightOrderStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof FreightOrder)) return false;
        final FreightOrder other = (FreightOrder) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$freightOrderId = this.getFreightOrderId();
        final java.lang.Object other$freightOrderId = other.getFreightOrderId();
        if (this$freightOrderId == null ? other$freightOrderId != null : !this$freightOrderId.equals(other$freightOrderId)) return false;
        final java.lang.Object this$shipperId = this.getShipperId();
        final java.lang.Object other$shipperId = other.getShipperId();
        if (this$shipperId == null ? other$shipperId != null : !this$shipperId.equals(other$shipperId)) return false;
        final java.lang.Object this$originLocationId = this.getOriginLocationId();
        final java.lang.Object other$originLocationId = other.getOriginLocationId();
        if (this$originLocationId == null ? other$originLocationId != null : !this$originLocationId.equals(other$originLocationId)) return false;
        final java.lang.Object this$destinationLocationId = this.getDestinationLocationId();
        final java.lang.Object other$destinationLocationId = other.getDestinationLocationId();
        if (this$destinationLocationId == null ? other$destinationLocationId != null : !this$destinationLocationId.equals(other$destinationLocationId)) return false;
        final java.lang.Object this$cargoDescription = this.getCargoDescription();
        final java.lang.Object other$cargoDescription = other.getCargoDescription();
        if (this$cargoDescription == null ? other$cargoDescription != null : !this$cargoDescription.equals(other$cargoDescription)) return false;
        final java.lang.Object this$weight = this.getWeight();
        final java.lang.Object other$weight = other.getWeight();
        if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight)) return false;
        final java.lang.Object this$volume = this.getVolume();
        final java.lang.Object other$volume = other.getVolume();
        if (this$volume == null ? other$volume != null : !this$volume.equals(other$volume)) return false;
        final java.lang.Object this$requiredDeliveryDate = this.getRequiredDeliveryDate();
        final java.lang.Object other$requiredDeliveryDate = other.getRequiredDeliveryDate();
        if (this$requiredDeliveryDate == null ? other$requiredDeliveryDate != null : !this$requiredDeliveryDate.equals(other$requiredDeliveryDate)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof FreightOrder;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $freightOrderId = this.getFreightOrderId();
        result = result * PRIME + ($freightOrderId == null ? 43 : $freightOrderId.hashCode());
        final java.lang.Object $shipperId = this.getShipperId();
        result = result * PRIME + ($shipperId == null ? 43 : $shipperId.hashCode());
        final java.lang.Object $originLocationId = this.getOriginLocationId();
        result = result * PRIME + ($originLocationId == null ? 43 : $originLocationId.hashCode());
        final java.lang.Object $destinationLocationId = this.getDestinationLocationId();
        result = result * PRIME + ($destinationLocationId == null ? 43 : $destinationLocationId.hashCode());
        final java.lang.Object $cargoDescription = this.getCargoDescription();
        result = result * PRIME + ($cargoDescription == null ? 43 : $cargoDescription.hashCode());
        final java.lang.Object $weight = this.getWeight();
        result = result * PRIME + ($weight == null ? 43 : $weight.hashCode());
        final java.lang.Object $volume = this.getVolume();
        result = result * PRIME + ($volume == null ? 43 : $volume.hashCode());
        final java.lang.Object $requiredDeliveryDate = this.getRequiredDeliveryDate();
        result = result * PRIME + ($requiredDeliveryDate == null ? 43 : $requiredDeliveryDate.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "FreightOrder(freightOrderId=" + this.getFreightOrderId() + ", shipperId=" + this.getShipperId() + ", originLocationId=" + this.getOriginLocationId() + ", destinationLocationId=" + this.getDestinationLocationId() + ", cargoDescription=" + this.getCargoDescription() + ", weight=" + this.getWeight() + ", volume=" + this.getVolume() + ", requiredDeliveryDate=" + this.getRequiredDeliveryDate() + ", status=" + this.getStatus() + ")";
    }

    public FreightOrder() {
        this.status = FreightOrder.$default$status();
    }

    public FreightOrder(final Integer freightOrderId, final Integer shipperId, final Integer originLocationId, final Integer destinationLocationId, final String cargoDescription, final BigDecimal weight, final BigDecimal volume, final LocalDate requiredDeliveryDate, final FreightOrderStatus status) {
        this.freightOrderId = freightOrderId;
        this.shipperId = shipperId;
        this.originLocationId = originLocationId;
        this.destinationLocationId = destinationLocationId;
        this.cargoDescription = cargoDescription;
        this.weight = weight;
        this.volume = volume;
        this.requiredDeliveryDate = requiredDeliveryDate;
        this.status = status;
    }
}

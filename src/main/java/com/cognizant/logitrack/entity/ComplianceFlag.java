package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.FlagSeverity;
import com.cognizant.logitrack.enums.FlagStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;

@Entity
@Table(name = "compliance_flags")
public class ComplianceFlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flagId;
    private Integer shipmentId;
    @Column(length = 50)
    private String flagType;
    @Enumerated(EnumType.STRING)
    private FlagSeverity severity;
    @CreationTimestamp
    private LocalDate raisedDate;
    @Enumerated(EnumType.STRING)
    private FlagStatus status;

    private static FlagStatus $default$status() {
        return FlagStatus.OPEN;
    }


    public static class ComplianceFlagBuilder {
        private Integer flagId;
        private Integer shipmentId;
        private String flagType;
        private FlagSeverity severity;
        private LocalDate raisedDate;
        private boolean status$set;
        private FlagStatus status$value;

        ComplianceFlagBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public ComplianceFlag.ComplianceFlagBuilder flagId(final Integer flagId) {
            this.flagId = flagId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ComplianceFlag.ComplianceFlagBuilder shipmentId(final Integer shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ComplianceFlag.ComplianceFlagBuilder flagType(final String flagType) {
            this.flagType = flagType;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ComplianceFlag.ComplianceFlagBuilder severity(final FlagSeverity severity) {
            this.severity = severity;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ComplianceFlag.ComplianceFlagBuilder raisedDate(final LocalDate raisedDate) {
            this.raisedDate = raisedDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ComplianceFlag.ComplianceFlagBuilder status(final FlagStatus status) {
            this.status$value = status;
            status$set = true;
            return this;
        }

        public ComplianceFlag build() {
            FlagStatus status$value = this.status$value;
            if (!this.status$set) status$value = ComplianceFlag.$default$status();
            return new ComplianceFlag(this.flagId, this.shipmentId, this.flagType, this.severity, this.raisedDate, status$value);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "ComplianceFlag.ComplianceFlagBuilder(flagId=" + this.flagId + ", shipmentId=" + this.shipmentId + ", flagType=" + this.flagType + ", severity=" + this.severity + ", raisedDate=" + this.raisedDate + ", status$value=" + this.status$value + ")";
        }
    }

    public static ComplianceFlag.ComplianceFlagBuilder builder() {
        return new ComplianceFlag.ComplianceFlagBuilder();
    }

    public Integer getFlagId() {
        return this.flagId;
    }

    public Integer getShipmentId() {
        return this.shipmentId;
    }

    public String getFlagType() {
        return this.flagType;
    }

    public FlagSeverity getSeverity() {
        return this.severity;
    }

    public LocalDate getRaisedDate() {
        return this.raisedDate;
    }

    public FlagStatus getStatus() {
        return this.status;
    }

    public void setFlagId(final Integer flagId) {
        this.flagId = flagId;
    }

    public void setShipmentId(final Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setFlagType(final String flagType) {
        this.flagType = flagType;
    }

    public void setSeverity(final FlagSeverity severity) {
        this.severity = severity;
    }

    public void setRaisedDate(final LocalDate raisedDate) {
        this.raisedDate = raisedDate;
    }

    public void setStatus(final FlagStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ComplianceFlag)) return false;
        final ComplianceFlag other = (ComplianceFlag) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$flagId = this.getFlagId();
        final java.lang.Object other$flagId = other.getFlagId();
        if (this$flagId == null ? other$flagId != null : !this$flagId.equals(other$flagId)) return false;
        final java.lang.Object this$shipmentId = this.getShipmentId();
        final java.lang.Object other$shipmentId = other.getShipmentId();
        if (this$shipmentId == null ? other$shipmentId != null : !this$shipmentId.equals(other$shipmentId)) return false;
        final java.lang.Object this$flagType = this.getFlagType();
        final java.lang.Object other$flagType = other.getFlagType();
        if (this$flagType == null ? other$flagType != null : !this$flagType.equals(other$flagType)) return false;
        final java.lang.Object this$severity = this.getSeverity();
        final java.lang.Object other$severity = other.getSeverity();
        if (this$severity == null ? other$severity != null : !this$severity.equals(other$severity)) return false;
        final java.lang.Object this$raisedDate = this.getRaisedDate();
        final java.lang.Object other$raisedDate = other.getRaisedDate();
        if (this$raisedDate == null ? other$raisedDate != null : !this$raisedDate.equals(other$raisedDate)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ComplianceFlag;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $flagId = this.getFlagId();
        result = result * PRIME + ($flagId == null ? 43 : $flagId.hashCode());
        final java.lang.Object $shipmentId = this.getShipmentId();
        result = result * PRIME + ($shipmentId == null ? 43 : $shipmentId.hashCode());
        final java.lang.Object $flagType = this.getFlagType();
        result = result * PRIME + ($flagType == null ? 43 : $flagType.hashCode());
        final java.lang.Object $severity = this.getSeverity();
        result = result * PRIME + ($severity == null ? 43 : $severity.hashCode());
        final java.lang.Object $raisedDate = this.getRaisedDate();
        result = result * PRIME + ($raisedDate == null ? 43 : $raisedDate.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ComplianceFlag(flagId=" + this.getFlagId() + ", shipmentId=" + this.getShipmentId() + ", flagType=" + this.getFlagType() + ", severity=" + this.getSeverity() + ", raisedDate=" + this.getRaisedDate() + ", status=" + this.getStatus() + ")";
    }

    public ComplianceFlag() {
        this.status = ComplianceFlag.$default$status();
    }

    public ComplianceFlag(final Integer flagId, final Integer shipmentId, final String flagType, final FlagSeverity severity, final LocalDate raisedDate, final FlagStatus status) {
        this.flagId = flagId;
        this.shipmentId = shipmentId;
        this.flagType = flagType;
        this.severity = severity;
        this.raisedDate = raisedDate;
        this.status = status;
    }
}

package com.cognizant.logitrack.dto;

import java.time.LocalDateTime;

public class ReportRequestDTO {
    private String scope;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;

    public String getScope() {
        return this.scope;
    }

    public LocalDateTime getFromDate() {
        return this.fromDate;
    }

    public LocalDateTime getToDate() {
        return this.toDate;
    }

    public void setScope(final String scope) {
        this.scope = scope;
    }

    public void setFromDate(final LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(final LocalDateTime toDate) {
        this.toDate = toDate;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ReportRequestDTO)) return false;
        final ReportRequestDTO other = (ReportRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$scope = this.getScope();
        final java.lang.Object other$scope = other.getScope();
        if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) return false;
        final java.lang.Object this$fromDate = this.getFromDate();
        final java.lang.Object other$fromDate = other.getFromDate();
        if (this$fromDate == null ? other$fromDate != null : !this$fromDate.equals(other$fromDate)) return false;
        final java.lang.Object this$toDate = this.getToDate();
        final java.lang.Object other$toDate = other.getToDate();
        if (this$toDate == null ? other$toDate != null : !this$toDate.equals(other$toDate)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ReportRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $scope = this.getScope();
        result = result * PRIME + ($scope == null ? 43 : $scope.hashCode());
        final java.lang.Object $fromDate = this.getFromDate();
        result = result * PRIME + ($fromDate == null ? 43 : $fromDate.hashCode());
        final java.lang.Object $toDate = this.getToDate();
        result = result * PRIME + ($toDate == null ? 43 : $toDate.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ReportRequestDTO(scope=" + this.getScope() + ", fromDate=" + this.getFromDate() + ", toDate=" + this.getToDate() + ")";
    }

    public ReportRequestDTO() {
    }

    public ReportRequestDTO(final String scope, final LocalDateTime fromDate, final LocalDateTime toDate) {
        this.scope = scope;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}

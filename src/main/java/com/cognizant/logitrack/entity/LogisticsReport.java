package com.cognizant.logitrack.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "logistics_reports")
public class LogisticsReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;
    @Column(length = 50)
    private String scope;
    @Column(columnDefinition = "TEXT")
    private String metrics;
    @CreationTimestamp
    private LocalDateTime generatedDate;


    public static class LogisticsReportBuilder {
        private Integer reportId;
        private String scope;
        private String metrics;
        private LocalDateTime generatedDate;

        LogisticsReportBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public LogisticsReport.LogisticsReportBuilder reportId(final Integer reportId) {
            this.reportId = reportId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public LogisticsReport.LogisticsReportBuilder scope(final String scope) {
            this.scope = scope;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public LogisticsReport.LogisticsReportBuilder metrics(final String metrics) {
            this.metrics = metrics;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public LogisticsReport.LogisticsReportBuilder generatedDate(final LocalDateTime generatedDate) {
            this.generatedDate = generatedDate;
            return this;
        }

        public LogisticsReport build() {
            return new LogisticsReport(this.reportId, this.scope, this.metrics, this.generatedDate);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "LogisticsReport.LogisticsReportBuilder(reportId=" + this.reportId + ", scope=" + this.scope + ", metrics=" + this.metrics + ", generatedDate=" + this.generatedDate + ")";
        }
    }

    public static LogisticsReport.LogisticsReportBuilder builder() {
        return new LogisticsReport.LogisticsReportBuilder();
    }

    public Integer getReportId() {
        return this.reportId;
    }

    public String getScope() {
        return this.scope;
    }

    public String getMetrics() {
        return this.metrics;
    }

    public LocalDateTime getGeneratedDate() {
        return this.generatedDate;
    }

    public void setReportId(final Integer reportId) {
        this.reportId = reportId;
    }

    public void setScope(final String scope) {
        this.scope = scope;
    }

    public void setMetrics(final String metrics) {
        this.metrics = metrics;
    }

    public void setGeneratedDate(final LocalDateTime generatedDate) {
        this.generatedDate = generatedDate;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof LogisticsReport)) return false;
        final LogisticsReport other = (LogisticsReport) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$reportId = this.getReportId();
        final java.lang.Object other$reportId = other.getReportId();
        if (this$reportId == null ? other$reportId != null : !this$reportId.equals(other$reportId)) return false;
        final java.lang.Object this$scope = this.getScope();
        final java.lang.Object other$scope = other.getScope();
        if (this$scope == null ? other$scope != null : !this$scope.equals(other$scope)) return false;
        final java.lang.Object this$metrics = this.getMetrics();
        final java.lang.Object other$metrics = other.getMetrics();
        if (this$metrics == null ? other$metrics != null : !this$metrics.equals(other$metrics)) return false;
        final java.lang.Object this$generatedDate = this.getGeneratedDate();
        final java.lang.Object other$generatedDate = other.getGeneratedDate();
        if (this$generatedDate == null ? other$generatedDate != null : !this$generatedDate.equals(other$generatedDate)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof LogisticsReport;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $reportId = this.getReportId();
        result = result * PRIME + ($reportId == null ? 43 : $reportId.hashCode());
        final java.lang.Object $scope = this.getScope();
        result = result * PRIME + ($scope == null ? 43 : $scope.hashCode());
        final java.lang.Object $metrics = this.getMetrics();
        result = result * PRIME + ($metrics == null ? 43 : $metrics.hashCode());
        final java.lang.Object $generatedDate = this.getGeneratedDate();
        result = result * PRIME + ($generatedDate == null ? 43 : $generatedDate.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "LogisticsReport(reportId=" + this.getReportId() + ", scope=" + this.getScope() + ", metrics=" + this.getMetrics() + ", generatedDate=" + this.getGeneratedDate() + ")";
    }

    public LogisticsReport() {
    }

    public LogisticsReport(final Integer reportId, final String scope, final String metrics, final LocalDateTime generatedDate) {
        this.reportId = reportId;
        this.scope = scope;
        this.metrics = metrics;
        this.generatedDate = generatedDate;
    }
}

package com.cognizant.logitrack.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auditId;
    private Integer userId;
    @Column(length = 50)
    private String action;
    private String entityType;
    private Integer entityId;
    @CreationTimestamp
    private LocalDateTime timestamp;


    public static class AuditLogBuilder {
        private Integer auditId;
        private Integer userId;
        private String action;
        private String entityType;
        private Integer entityId;
        private LocalDateTime timestamp;

        AuditLogBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public AuditLog.AuditLogBuilder auditId(final Integer auditId) {
            this.auditId = auditId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public AuditLog.AuditLogBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public AuditLog.AuditLogBuilder action(final String action) {
            this.action = action;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public AuditLog.AuditLogBuilder entityType(final String entityType) {
            this.entityType = entityType;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public AuditLog.AuditLogBuilder entityId(final Integer entityId) {
            this.entityId = entityId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public AuditLog.AuditLogBuilder timestamp(final LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public AuditLog build() {
            return new AuditLog(this.auditId, this.userId, this.action, this.entityType, this.entityId, this.timestamp);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "AuditLog.AuditLogBuilder(auditId=" + this.auditId + ", userId=" + this.userId + ", action=" + this.action + ", entityType=" + this.entityType + ", entityId=" + this.entityId + ", timestamp=" + this.timestamp + ")";
        }
    }

    public static AuditLog.AuditLogBuilder builder() {
        return new AuditLog.AuditLogBuilder();
    }

    public Integer getAuditId() {
        return this.auditId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public String getAction() {
        return this.action;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public Integer getEntityId() {
        return this.entityId;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setAuditId(final Integer auditId) {
        this.auditId = auditId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public void setEntityType(final String entityType) {
        this.entityType = entityType;
    }

    public void setEntityId(final Integer entityId) {
        this.entityId = entityId;
    }

    public void setTimestamp(final LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof AuditLog)) return false;
        final AuditLog other = (AuditLog) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$auditId = this.getAuditId();
        final java.lang.Object other$auditId = other.getAuditId();
        if (this$auditId == null ? other$auditId != null : !this$auditId.equals(other$auditId)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$entityId = this.getEntityId();
        final java.lang.Object other$entityId = other.getEntityId();
        if (this$entityId == null ? other$entityId != null : !this$entityId.equals(other$entityId)) return false;
        final java.lang.Object this$action = this.getAction();
        final java.lang.Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) return false;
        final java.lang.Object this$entityType = this.getEntityType();
        final java.lang.Object other$entityType = other.getEntityType();
        if (this$entityType == null ? other$entityType != null : !this$entityType.equals(other$entityType)) return false;
        final java.lang.Object this$timestamp = this.getTimestamp();
        final java.lang.Object other$timestamp = other.getTimestamp();
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof AuditLog;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $auditId = this.getAuditId();
        result = result * PRIME + ($auditId == null ? 43 : $auditId.hashCode());
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $entityId = this.getEntityId();
        result = result * PRIME + ($entityId == null ? 43 : $entityId.hashCode());
        final java.lang.Object $action = this.getAction();
        result = result * PRIME + ($action == null ? 43 : $action.hashCode());
        final java.lang.Object $entityType = this.getEntityType();
        result = result * PRIME + ($entityType == null ? 43 : $entityType.hashCode());
        final java.lang.Object $timestamp = this.getTimestamp();
        result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "AuditLog(auditId=" + this.getAuditId() + ", userId=" + this.getUserId() + ", action=" + this.getAction() + ", entityType=" + this.getEntityType() + ", entityId=" + this.getEntityId() + ", timestamp=" + this.getTimestamp() + ")";
    }

    public AuditLog() {
    }

    public AuditLog(final Integer auditId, final Integer userId, final String action, final String entityType, final Integer entityId, final LocalDateTime timestamp) {
        this.auditId = auditId;
        this.userId = userId;
        this.action = action;
        this.entityType = entityType;
        this.entityId = entityId;
        this.timestamp = timestamp;
    }
}

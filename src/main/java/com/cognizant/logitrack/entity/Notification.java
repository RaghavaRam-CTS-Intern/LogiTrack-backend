package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.NotificationCategory;
import com.cognizant.logitrack.enums.NotificationStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;
    private Integer userId;
    @Column(columnDefinition = "TEXT")
    private String message;
    @Enumerated(EnumType.STRING)
    private NotificationCategory category;
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
    @CreationTimestamp
    private LocalDateTime createdDate;

    private static NotificationStatus $default$status() {
        return NotificationStatus.UNREAD;
    }


    public static class NotificationBuilder {
        private Integer notificationId;
        private Integer userId;
        private String message;
        private NotificationCategory category;
        private boolean status$set;
        private NotificationStatus status$value;
        private LocalDateTime createdDate;

        NotificationBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public Notification.NotificationBuilder notificationId(final Integer notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Notification.NotificationBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Notification.NotificationBuilder message(final String message) {
            this.message = message;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Notification.NotificationBuilder category(final NotificationCategory category) {
            this.category = category;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Notification.NotificationBuilder status(final NotificationStatus status) {
            this.status$value = status;
            status$set = true;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Notification.NotificationBuilder createdDate(final LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Notification build() {
            NotificationStatus status$value = this.status$value;
            if (!this.status$set) status$value = Notification.$default$status();
            return new Notification(this.notificationId, this.userId, this.message, this.category, status$value, this.createdDate);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Notification.NotificationBuilder(notificationId=" + this.notificationId + ", userId=" + this.userId + ", message=" + this.message + ", category=" + this.category + ", status$value=" + this.status$value + ", createdDate=" + this.createdDate + ")";
        }
    }

    public static Notification.NotificationBuilder builder() {
        return new Notification.NotificationBuilder();
    }

    public Integer getNotificationId() {
        return this.notificationId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public String getMessage() {
        return this.message;
    }

    public NotificationCategory getCategory() {
        return this.category;
    }

    public NotificationStatus getStatus() {
        return this.status;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setNotificationId(final Integer notificationId) {
        this.notificationId = notificationId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setCategory(final NotificationCategory category) {
        this.category = category;
    }

    public void setStatus(final NotificationStatus status) {
        this.status = status;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof Notification)) return false;
        final Notification other = (Notification) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$notificationId = this.getNotificationId();
        final java.lang.Object other$notificationId = other.getNotificationId();
        if (this$notificationId == null ? other$notificationId != null : !this$notificationId.equals(other$notificationId)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$message = this.getMessage();
        final java.lang.Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final java.lang.Object this$category = this.getCategory();
        final java.lang.Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final java.lang.Object this$createdDate = this.getCreatedDate();
        final java.lang.Object other$createdDate = other.getCreatedDate();
        if (this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof Notification;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $notificationId = this.getNotificationId();
        result = result * PRIME + ($notificationId == null ? 43 : $notificationId.hashCode());
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final java.lang.Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final java.lang.Object $createdDate = this.getCreatedDate();
        result = result * PRIME + ($createdDate == null ? 43 : $createdDate.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Notification(notificationId=" + this.getNotificationId() + ", userId=" + this.getUserId() + ", message=" + this.getMessage() + ", category=" + this.getCategory() + ", status=" + this.getStatus() + ", createdDate=" + this.getCreatedDate() + ")";
    }

    public Notification() {
        this.status = Notification.$default$status();
    }

    public Notification(final Integer notificationId, final Integer userId, final String message, final NotificationCategory category, final NotificationStatus status, final LocalDateTime createdDate) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.category = category;
        this.status = status;
        this.createdDate = createdDate;
    }
}

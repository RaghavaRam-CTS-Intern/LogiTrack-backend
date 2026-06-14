package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.NotificationCategory;
import com.cognizant.logitrack.enums.NotificationStatus;
import java.time.LocalDateTime;

public class NotificationDTO {
    private Integer notificationId;
    private Integer userId;
    private String message;
    private NotificationCategory category;
    private NotificationStatus status;
    private LocalDateTime createdDate;


    public static class NotificationDTOBuilder {
        private Integer notificationId;
        private Integer userId;
        private String message;
        private NotificationCategory category;
        private NotificationStatus status;
        private LocalDateTime createdDate;

        NotificationDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public NotificationDTO.NotificationDTOBuilder notificationId(final Integer notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NotificationDTO.NotificationDTOBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NotificationDTO.NotificationDTOBuilder message(final String message) {
            this.message = message;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NotificationDTO.NotificationDTOBuilder category(final NotificationCategory category) {
            this.category = category;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NotificationDTO.NotificationDTOBuilder status(final NotificationStatus status) {
            this.status = status;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public NotificationDTO.NotificationDTOBuilder createdDate(final LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public NotificationDTO build() {
            return new NotificationDTO(this.notificationId, this.userId, this.message, this.category, this.status, this.createdDate);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "NotificationDTO.NotificationDTOBuilder(notificationId=" + this.notificationId + ", userId=" + this.userId + ", message=" + this.message + ", category=" + this.category + ", status=" + this.status + ", createdDate=" + this.createdDate + ")";
        }
    }

    public static NotificationDTO.NotificationDTOBuilder builder() {
        return new NotificationDTO.NotificationDTOBuilder();
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
        if (!(o instanceof NotificationDTO)) return false;
        final NotificationDTO other = (NotificationDTO) o;
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
        return other instanceof NotificationDTO;
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
        return "NotificationDTO(notificationId=" + this.getNotificationId() + ", userId=" + this.getUserId() + ", message=" + this.getMessage() + ", category=" + this.getCategory() + ", status=" + this.getStatus() + ", createdDate=" + this.getCreatedDate() + ")";
    }

    public NotificationDTO() {
    }

    public NotificationDTO(final Integer notificationId, final Integer userId, final String message, final NotificationCategory category, final NotificationStatus status, final LocalDateTime createdDate) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.category = category;
        this.status = status;
        this.createdDate = createdDate;
    }
}

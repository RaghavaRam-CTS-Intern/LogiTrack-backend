package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.NotificationCategory;
import jakarta.validation.constraints.NotNull;

public class NotificationRequestDTO {
    @NotNull
    private Integer userId;
    private String message;
    @NotNull
    private NotificationCategory category;

    public Integer getUserId() {
        return this.userId;
    }

    public String getMessage() {
        return this.message;
    }

    public NotificationCategory getCategory() {
        return this.category;
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

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof NotificationRequestDTO)) return false;
        final NotificationRequestDTO other = (NotificationRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$message = this.getMessage();
        final java.lang.Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final java.lang.Object this$category = this.getCategory();
        final java.lang.Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof NotificationRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final java.lang.Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "NotificationRequestDTO(userId=" + this.getUserId() + ", message=" + this.getMessage() + ", category=" + this.getCategory() + ")";
    }

    public NotificationRequestDTO() {
    }

    public NotificationRequestDTO(final Integer userId, final String message, final NotificationCategory category) {
        this.userId = userId;
        this.message = message;
        this.category = category;
    }
}

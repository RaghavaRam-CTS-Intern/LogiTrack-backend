package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.Role;
import com.cognizant.logitrack.enums.UserStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(unique = true)
    private String email;
    private String phone;
    private Integer hubId;
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private static UserStatus $default$status() {
        return UserStatus.ACTIVE;
    }


    public static class UserBuilder {
        private Integer userId;
        private String name;
        private Role role;
        private String email;
        private String phone;
        private Integer hubId;
        private String passwordHash;
        private boolean status$set;
        private UserStatus status$value;

        UserBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public User.UserBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public User.UserBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public User.UserBuilder role(final Role role) {
            this.role = role;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public User.UserBuilder email(final String email) {
            this.email = email;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public User.UserBuilder phone(final String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public User.UserBuilder hubId(final Integer hubId) {
            this.hubId = hubId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public User.UserBuilder passwordHash(final String passwordHash) {
            this.passwordHash = passwordHash;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public User.UserBuilder status(final UserStatus status) {
            this.status$value = status;
            status$set = true;
            return this;
        }

        public User build() {
            UserStatus status$value = this.status$value;
            if (!this.status$set) status$value = User.$default$status();
            return new User(this.userId, this.name, this.role, this.email, this.phone, this.hubId, this.passwordHash, status$value);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "User.UserBuilder(userId=" + this.userId + ", name=" + this.name + ", role=" + this.role + ", email=" + this.email + ", phone=" + this.phone + ", hubId=" + this.hubId + ", passwordHash=" + this.passwordHash + ", status$value=" + this.status$value + ")";
        }
    }

    public static User.UserBuilder builder() {
        return new User.UserBuilder();
    }

    public Integer getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public Role getRole() {
        return this.role;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public Integer getHubId() {
        return this.hubId;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public UserStatus getStatus() {
        return this.status;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setHubId(final Integer hubId) {
        this.hubId = hubId;
    }

    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setStatus(final UserStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$hubId = this.getHubId();
        final java.lang.Object other$hubId = other.getHubId();
        if (this$hubId == null ? other$hubId != null : !this$hubId.equals(other$hubId)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$role = this.getRole();
        final java.lang.Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final java.lang.Object this$email = this.getEmail();
        final java.lang.Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final java.lang.Object this$phone = this.getPhone();
        final java.lang.Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final java.lang.Object this$passwordHash = this.getPasswordHash();
        final java.lang.Object other$passwordHash = other.getPasswordHash();
        if (this$passwordHash == null ? other$passwordHash != null : !this$passwordHash.equals(other$passwordHash)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof User;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $hubId = this.getHubId();
        result = result * PRIME + ($hubId == null ? 43 : $hubId.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final java.lang.Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final java.lang.Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final java.lang.Object $passwordHash = this.getPasswordHash();
        result = result * PRIME + ($passwordHash == null ? 43 : $passwordHash.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User(userId=" + this.getUserId() + ", name=" + this.getName() + ", role=" + this.getRole() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ", hubId=" + this.getHubId() + ", passwordHash=" + this.getPasswordHash() + ", status=" + this.getStatus() + ")";
    }

    public User() {
        this.status = User.$default$status();
    }

    public User(final Integer userId, final String name, final Role role, final String email, final String phone, final Integer hubId, final String passwordHash, final UserStatus status) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.hubId = hubId;
        this.passwordHash = passwordHash;
        this.status = status;
    }
}

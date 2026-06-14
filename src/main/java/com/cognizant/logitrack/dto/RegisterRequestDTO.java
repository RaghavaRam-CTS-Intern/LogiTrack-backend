package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotNull
    private Role role;
    private String phone;
    private Integer hubId;

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Role getRole() {
        return this.role;
    }

    public String getPhone() {
        return this.phone;
    }

    public Integer getHubId() {
        return this.hubId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setHubId(final Integer hubId) {
        this.hubId = hubId;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof RegisterRequestDTO)) return false;
        final RegisterRequestDTO other = (RegisterRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$hubId = this.getHubId();
        final java.lang.Object other$hubId = other.getHubId();
        if (this$hubId == null ? other$hubId != null : !this$hubId.equals(other$hubId)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$email = this.getEmail();
        final java.lang.Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final java.lang.Object this$password = this.getPassword();
        final java.lang.Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final java.lang.Object this$role = this.getRole();
        final java.lang.Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final java.lang.Object this$phone = this.getPhone();
        final java.lang.Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof RegisterRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $hubId = this.getHubId();
        result = result * PRIME + ($hubId == null ? 43 : $hubId.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final java.lang.Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final java.lang.Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final java.lang.Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RegisterRequestDTO(name=" + this.getName() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", role=" + this.getRole() + ", phone=" + this.getPhone() + ", hubId=" + this.getHubId() + ")";
    }

    public RegisterRequestDTO() {
    }

    public RegisterRequestDTO(final String name, final String email, final String password, final Role role, final String phone, final Integer hubId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.hubId = hubId;
    }
}

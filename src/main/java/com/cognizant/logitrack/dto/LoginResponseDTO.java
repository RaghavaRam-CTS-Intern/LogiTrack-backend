package com.cognizant.logitrack.dto;

public class LoginResponseDTO {
    private String token;
    private String role;
    private Integer userId;
    private String name;


    public static class LoginResponseDTOBuilder {
        private String token;
        private String role;
        private Integer userId;
        private String name;

        LoginResponseDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public LoginResponseDTO.LoginResponseDTOBuilder token(final String token) {
            this.token = token;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public LoginResponseDTO.LoginResponseDTOBuilder role(final String role) {
            this.role = role;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public LoginResponseDTO.LoginResponseDTOBuilder userId(final Integer userId) {
            this.userId = userId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public LoginResponseDTO.LoginResponseDTOBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public LoginResponseDTO build() {
            return new LoginResponseDTO(this.token, this.role, this.userId, this.name);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "LoginResponseDTO.LoginResponseDTOBuilder(token=" + this.token + ", role=" + this.role + ", userId=" + this.userId + ", name=" + this.name + ")";
        }
    }

    public static LoginResponseDTO.LoginResponseDTOBuilder builder() {
        return new LoginResponseDTO.LoginResponseDTOBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public String getRole() {
        return this.role;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof LoginResponseDTO)) return false;
        final LoginResponseDTO other = (LoginResponseDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$token = this.getToken();
        final java.lang.Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        final java.lang.Object this$role = this.getRole();
        final java.lang.Object other$role = other.getRole();
        if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof LoginResponseDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        final java.lang.Object $role = this.getRole();
        result = result * PRIME + ($role == null ? 43 : $role.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "LoginResponseDTO(token=" + this.getToken() + ", role=" + this.getRole() + ", userId=" + this.getUserId() + ", name=" + this.getName() + ")";
    }

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(final String token, final String role, final Integer userId, final String name) {
        this.token = token;
        this.role = role;
        this.userId = userId;
        this.name = name;
    }
}

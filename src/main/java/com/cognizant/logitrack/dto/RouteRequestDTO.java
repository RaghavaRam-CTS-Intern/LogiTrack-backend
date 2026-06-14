package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.RouteMode;
import jakarta.validation.constraints.NotNull;

public class RouteRequestDTO {
    @NotNull
    private Integer originHubId;
    @NotNull
    private Integer destinationHubId;
    private Integer transitDays;
    @NotNull
    private RouteMode mode;

    public Integer getOriginHubId() {
        return this.originHubId;
    }

    public Integer getDestinationHubId() {
        return this.destinationHubId;
    }

    public Integer getTransitDays() {
        return this.transitDays;
    }

    public RouteMode getMode() {
        return this.mode;
    }

    public void setOriginHubId(final Integer originHubId) {
        this.originHubId = originHubId;
    }

    public void setDestinationHubId(final Integer destinationHubId) {
        this.destinationHubId = destinationHubId;
    }

    public void setTransitDays(final Integer transitDays) {
        this.transitDays = transitDays;
    }

    public void setMode(final RouteMode mode) {
        this.mode = mode;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof RouteRequestDTO)) return false;
        final RouteRequestDTO other = (RouteRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$originHubId = this.getOriginHubId();
        final java.lang.Object other$originHubId = other.getOriginHubId();
        if (this$originHubId == null ? other$originHubId != null : !this$originHubId.equals(other$originHubId)) return false;
        final java.lang.Object this$destinationHubId = this.getDestinationHubId();
        final java.lang.Object other$destinationHubId = other.getDestinationHubId();
        if (this$destinationHubId == null ? other$destinationHubId != null : !this$destinationHubId.equals(other$destinationHubId)) return false;
        final java.lang.Object this$transitDays = this.getTransitDays();
        final java.lang.Object other$transitDays = other.getTransitDays();
        if (this$transitDays == null ? other$transitDays != null : !this$transitDays.equals(other$transitDays)) return false;
        final java.lang.Object this$mode = this.getMode();
        final java.lang.Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof RouteRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $originHubId = this.getOriginHubId();
        result = result * PRIME + ($originHubId == null ? 43 : $originHubId.hashCode());
        final java.lang.Object $destinationHubId = this.getDestinationHubId();
        result = result * PRIME + ($destinationHubId == null ? 43 : $destinationHubId.hashCode());
        final java.lang.Object $transitDays = this.getTransitDays();
        result = result * PRIME + ($transitDays == null ? 43 : $transitDays.hashCode());
        final java.lang.Object $mode = this.getMode();
        result = result * PRIME + ($mode == null ? 43 : $mode.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RouteRequestDTO(originHubId=" + this.getOriginHubId() + ", destinationHubId=" + this.getDestinationHubId() + ", transitDays=" + this.getTransitDays() + ", mode=" + this.getMode() + ")";
    }

    public RouteRequestDTO() {
    }

    public RouteRequestDTO(final Integer originHubId, final Integer destinationHubId, final Integer transitDays, final RouteMode mode) {
        this.originHubId = originHubId;
        this.destinationHubId = destinationHubId;
        this.transitDays = transitDays;
        this.mode = mode;
    }
}

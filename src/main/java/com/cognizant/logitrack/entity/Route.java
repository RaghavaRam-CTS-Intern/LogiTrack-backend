package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.RouteMode;
import com.cognizant.logitrack.enums.RouteStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;
    private Integer originHubId;
    private Integer destinationHubId;
    private Integer transitDays;
    @Enumerated(EnumType.STRING)
    private RouteMode mode;
    @Enumerated(EnumType.STRING)
    private RouteStatus status;

    private static RouteStatus $default$status() {
        return RouteStatus.ACTIVE;
    }


    public static class RouteBuilder {
        private Integer routeId;
        private Integer originHubId;
        private Integer destinationHubId;
        private Integer transitDays;
        private RouteMode mode;
        private boolean status$set;
        private RouteStatus status$value;

        RouteBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public Route.RouteBuilder routeId(final Integer routeId) {
            this.routeId = routeId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Route.RouteBuilder originHubId(final Integer originHubId) {
            this.originHubId = originHubId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Route.RouteBuilder destinationHubId(final Integer destinationHubId) {
            this.destinationHubId = destinationHubId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Route.RouteBuilder transitDays(final Integer transitDays) {
            this.transitDays = transitDays;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Route.RouteBuilder mode(final RouteMode mode) {
            this.mode = mode;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public Route.RouteBuilder status(final RouteStatus status) {
            this.status$value = status;
            status$set = true;
            return this;
        }

        public Route build() {
            RouteStatus status$value = this.status$value;
            if (!this.status$set) status$value = Route.$default$status();
            return new Route(this.routeId, this.originHubId, this.destinationHubId, this.transitDays, this.mode, status$value);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Route.RouteBuilder(routeId=" + this.routeId + ", originHubId=" + this.originHubId + ", destinationHubId=" + this.destinationHubId + ", transitDays=" + this.transitDays + ", mode=" + this.mode + ", status$value=" + this.status$value + ")";
        }
    }

    public static Route.RouteBuilder builder() {
        return new Route.RouteBuilder();
    }

    public Integer getRouteId() {
        return this.routeId;
    }

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

    public RouteStatus getStatus() {
        return this.status;
    }

    public void setRouteId(final Integer routeId) {
        this.routeId = routeId;
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

    public void setStatus(final RouteStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof Route)) return false;
        final Route other = (Route) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$routeId = this.getRouteId();
        final java.lang.Object other$routeId = other.getRouteId();
        if (this$routeId == null ? other$routeId != null : !this$routeId.equals(other$routeId)) return false;
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
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof Route;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $routeId = this.getRouteId();
        result = result * PRIME + ($routeId == null ? 43 : $routeId.hashCode());
        final java.lang.Object $originHubId = this.getOriginHubId();
        result = result * PRIME + ($originHubId == null ? 43 : $originHubId.hashCode());
        final java.lang.Object $destinationHubId = this.getDestinationHubId();
        result = result * PRIME + ($destinationHubId == null ? 43 : $destinationHubId.hashCode());
        final java.lang.Object $transitDays = this.getTransitDays();
        result = result * PRIME + ($transitDays == null ? 43 : $transitDays.hashCode());
        final java.lang.Object $mode = this.getMode();
        result = result * PRIME + ($mode == null ? 43 : $mode.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Route(routeId=" + this.getRouteId() + ", originHubId=" + this.getOriginHubId() + ", destinationHubId=" + this.getDestinationHubId() + ", transitDays=" + this.getTransitDays() + ", mode=" + this.getMode() + ", status=" + this.getStatus() + ")";
    }

    public Route() {
        this.status = Route.$default$status();
    }

    public Route(final Integer routeId, final Integer originHubId, final Integer destinationHubId, final Integer transitDays, final RouteMode mode, final RouteStatus status) {
        this.routeId = routeId;
        this.originHubId = originHubId;
        this.destinationHubId = destinationHubId;
        this.transitDays = transitDays;
        this.mode = mode;
        this.status = status;
    }
}

package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.EventType;
import java.time.LocalDateTime;

public class DeliveryEventDTO {
    private Integer eventId;
    private Integer shipmentId;
    private EventType eventType;
    private LocalDateTime timestamp;
    private Integer locationId;
    private String notes;


    public static class DeliveryEventDTOBuilder {
        private Integer eventId;
        private Integer shipmentId;
        private EventType eventType;
        private LocalDateTime timestamp;
        private Integer locationId;
        private String notes;

        DeliveryEventDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEventDTO.DeliveryEventDTOBuilder eventId(final Integer eventId) {
            this.eventId = eventId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEventDTO.DeliveryEventDTOBuilder shipmentId(final Integer shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEventDTO.DeliveryEventDTOBuilder eventType(final EventType eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEventDTO.DeliveryEventDTOBuilder timestamp(final LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEventDTO.DeliveryEventDTOBuilder locationId(final Integer locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEventDTO.DeliveryEventDTOBuilder notes(final String notes) {
            this.notes = notes;
            return this;
        }

        public DeliveryEventDTO build() {
            return new DeliveryEventDTO(this.eventId, this.shipmentId, this.eventType, this.timestamp, this.locationId, this.notes);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "DeliveryEventDTO.DeliveryEventDTOBuilder(eventId=" + this.eventId + ", shipmentId=" + this.shipmentId + ", eventType=" + this.eventType + ", timestamp=" + this.timestamp + ", locationId=" + this.locationId + ", notes=" + this.notes + ")";
        }
    }

    public static DeliveryEventDTO.DeliveryEventDTOBuilder builder() {
        return new DeliveryEventDTO.DeliveryEventDTOBuilder();
    }

    public Integer getEventId() {
        return this.eventId;
    }

    public Integer getShipmentId() {
        return this.shipmentId;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public Integer getLocationId() {
        return this.locationId;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setEventId(final Integer eventId) {
        this.eventId = eventId;
    }

    public void setShipmentId(final Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setEventType(final EventType eventType) {
        this.eventType = eventType;
    }

    public void setTimestamp(final LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setLocationId(final Integer locationId) {
        this.locationId = locationId;
    }

    public void setNotes(final String notes) {
        this.notes = notes;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof DeliveryEventDTO)) return false;
        final DeliveryEventDTO other = (DeliveryEventDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$eventId = this.getEventId();
        final java.lang.Object other$eventId = other.getEventId();
        if (this$eventId == null ? other$eventId != null : !this$eventId.equals(other$eventId)) return false;
        final java.lang.Object this$shipmentId = this.getShipmentId();
        final java.lang.Object other$shipmentId = other.getShipmentId();
        if (this$shipmentId == null ? other$shipmentId != null : !this$shipmentId.equals(other$shipmentId)) return false;
        final java.lang.Object this$locationId = this.getLocationId();
        final java.lang.Object other$locationId = other.getLocationId();
        if (this$locationId == null ? other$locationId != null : !this$locationId.equals(other$locationId)) return false;
        final java.lang.Object this$eventType = this.getEventType();
        final java.lang.Object other$eventType = other.getEventType();
        if (this$eventType == null ? other$eventType != null : !this$eventType.equals(other$eventType)) return false;
        final java.lang.Object this$timestamp = this.getTimestamp();
        final java.lang.Object other$timestamp = other.getTimestamp();
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        final java.lang.Object this$notes = this.getNotes();
        final java.lang.Object other$notes = other.getNotes();
        if (this$notes == null ? other$notes != null : !this$notes.equals(other$notes)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof DeliveryEventDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $eventId = this.getEventId();
        result = result * PRIME + ($eventId == null ? 43 : $eventId.hashCode());
        final java.lang.Object $shipmentId = this.getShipmentId();
        result = result * PRIME + ($shipmentId == null ? 43 : $shipmentId.hashCode());
        final java.lang.Object $locationId = this.getLocationId();
        result = result * PRIME + ($locationId == null ? 43 : $locationId.hashCode());
        final java.lang.Object $eventType = this.getEventType();
        result = result * PRIME + ($eventType == null ? 43 : $eventType.hashCode());
        final java.lang.Object $timestamp = this.getTimestamp();
        result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
        final java.lang.Object $notes = this.getNotes();
        result = result * PRIME + ($notes == null ? 43 : $notes.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "DeliveryEventDTO(eventId=" + this.getEventId() + ", shipmentId=" + this.getShipmentId() + ", eventType=" + this.getEventType() + ", timestamp=" + this.getTimestamp() + ", locationId=" + this.getLocationId() + ", notes=" + this.getNotes() + ")";
    }

    public DeliveryEventDTO() {
    }

    public DeliveryEventDTO(final Integer eventId, final Integer shipmentId, final EventType eventType, final LocalDateTime timestamp, final Integer locationId, final String notes) {
        this.eventId = eventId;
        this.shipmentId = shipmentId;
        this.eventType = eventType;
        this.timestamp = timestamp;
        this.locationId = locationId;
        this.notes = notes;
    }
}

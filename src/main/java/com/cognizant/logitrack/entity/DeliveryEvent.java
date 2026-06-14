package com.cognizant.logitrack.entity;

import com.cognizant.logitrack.enums.EventType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_events")
public class DeliveryEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;
    @ManyToOne
    @JoinColumn(name = "ShipmentID")
    private Shipment shipment;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    @CreationTimestamp
    private LocalDateTime timestamp;
    private Integer locationId;
    @Column(columnDefinition = "TEXT")
    private String notes;


    public static class DeliveryEventBuilder {
        private Integer eventId;
        private Shipment shipment;
        private EventType eventType;
        private LocalDateTime timestamp;
        private Integer locationId;
        private String notes;

        DeliveryEventBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEvent.DeliveryEventBuilder eventId(final Integer eventId) {
            this.eventId = eventId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEvent.DeliveryEventBuilder shipment(final Shipment shipment) {
            this.shipment = shipment;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEvent.DeliveryEventBuilder eventType(final EventType eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEvent.DeliveryEventBuilder timestamp(final LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEvent.DeliveryEventBuilder locationId(final Integer locationId) {
            this.locationId = locationId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public DeliveryEvent.DeliveryEventBuilder notes(final String notes) {
            this.notes = notes;
            return this;
        }

        public DeliveryEvent build() {
            return new DeliveryEvent(this.eventId, this.shipment, this.eventType, this.timestamp, this.locationId, this.notes);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "DeliveryEvent.DeliveryEventBuilder(eventId=" + this.eventId + ", shipment=" + this.shipment + ", eventType=" + this.eventType + ", timestamp=" + this.timestamp + ", locationId=" + this.locationId + ", notes=" + this.notes + ")";
        }
    }

    public static DeliveryEvent.DeliveryEventBuilder builder() {
        return new DeliveryEvent.DeliveryEventBuilder();
    }

    public Integer getEventId() {
        return this.eventId;
    }

    public Shipment getShipment() {
        return this.shipment;
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

    public void setShipment(final Shipment shipment) {
        this.shipment = shipment;
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
        if (!(o instanceof DeliveryEvent)) return false;
        final DeliveryEvent other = (DeliveryEvent) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$eventId = this.getEventId();
        final java.lang.Object other$eventId = other.getEventId();
        if (this$eventId == null ? other$eventId != null : !this$eventId.equals(other$eventId)) return false;
        final java.lang.Object this$locationId = this.getLocationId();
        final java.lang.Object other$locationId = other.getLocationId();
        if (this$locationId == null ? other$locationId != null : !this$locationId.equals(other$locationId)) return false;
        final java.lang.Object this$shipment = this.getShipment();
        final java.lang.Object other$shipment = other.getShipment();
        if (this$shipment == null ? other$shipment != null : !this$shipment.equals(other$shipment)) return false;
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
        return other instanceof DeliveryEvent;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $eventId = this.getEventId();
        result = result * PRIME + ($eventId == null ? 43 : $eventId.hashCode());
        final java.lang.Object $locationId = this.getLocationId();
        result = result * PRIME + ($locationId == null ? 43 : $locationId.hashCode());
        final java.lang.Object $shipment = this.getShipment();
        result = result * PRIME + ($shipment == null ? 43 : $shipment.hashCode());
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
        return "DeliveryEvent(eventId=" + this.getEventId() + ", shipment=" + this.getShipment() + ", eventType=" + this.getEventType() + ", timestamp=" + this.getTimestamp() + ", locationId=" + this.getLocationId() + ", notes=" + this.getNotes() + ")";
    }

    public DeliveryEvent() {
    }

    public DeliveryEvent(final Integer eventId, final Shipment shipment, final EventType eventType, final LocalDateTime timestamp, final Integer locationId, final String notes) {
        this.eventId = eventId;
        this.shipment = shipment;
        this.eventType = eventType;
        this.timestamp = timestamp;
        this.locationId = locationId;
        this.notes = notes;
    }
}

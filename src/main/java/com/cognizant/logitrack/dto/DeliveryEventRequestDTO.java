package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.EventType;
import jakarta.validation.constraints.NotNull;

public class DeliveryEventRequestDTO {
    @NotNull
    private EventType eventType;
    private Integer locationId;
    private String notes;

    public EventType getEventType() {
        return this.eventType;
    }

    public Integer getLocationId() {
        return this.locationId;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setEventType(final EventType eventType) {
        this.eventType = eventType;
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
        if (!(o instanceof DeliveryEventRequestDTO)) return false;
        final DeliveryEventRequestDTO other = (DeliveryEventRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$locationId = this.getLocationId();
        final java.lang.Object other$locationId = other.getLocationId();
        if (this$locationId == null ? other$locationId != null : !this$locationId.equals(other$locationId)) return false;
        final java.lang.Object this$eventType = this.getEventType();
        final java.lang.Object other$eventType = other.getEventType();
        if (this$eventType == null ? other$eventType != null : !this$eventType.equals(other$eventType)) return false;
        final java.lang.Object this$notes = this.getNotes();
        final java.lang.Object other$notes = other.getNotes();
        if (this$notes == null ? other$notes != null : !this$notes.equals(other$notes)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof DeliveryEventRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $locationId = this.getLocationId();
        result = result * PRIME + ($locationId == null ? 43 : $locationId.hashCode());
        final java.lang.Object $eventType = this.getEventType();
        result = result * PRIME + ($eventType == null ? 43 : $eventType.hashCode());
        final java.lang.Object $notes = this.getNotes();
        result = result * PRIME + ($notes == null ? 43 : $notes.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "DeliveryEventRequestDTO(eventType=" + this.getEventType() + ", locationId=" + this.getLocationId() + ", notes=" + this.getNotes() + ")";
    }

    public DeliveryEventRequestDTO() {
    }

    public DeliveryEventRequestDTO(final EventType eventType, final Integer locationId, final String notes) {
        this.eventType = eventType;
        this.locationId = locationId;
        this.notes = notes;
    }
}

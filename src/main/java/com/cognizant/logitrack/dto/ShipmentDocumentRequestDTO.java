package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.DocumentType;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ShipmentDocumentRequestDTO {
    @NotNull
    private Integer shipmentId;
    @NotNull
    private DocumentType documentType;
    private String filePath;
    private LocalDate submittedDate;

    public Integer getShipmentId() {
        return this.shipmentId;
    }

    public DocumentType getDocumentType() {
        return this.documentType;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public LocalDate getSubmittedDate() {
        return this.submittedDate;
    }

    public void setShipmentId(final Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setDocumentType(final DocumentType documentType) {
        this.documentType = documentType;
    }

    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    public void setSubmittedDate(final LocalDate submittedDate) {
        this.submittedDate = submittedDate;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ShipmentDocumentRequestDTO)) return false;
        final ShipmentDocumentRequestDTO other = (ShipmentDocumentRequestDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$shipmentId = this.getShipmentId();
        final java.lang.Object other$shipmentId = other.getShipmentId();
        if (this$shipmentId == null ? other$shipmentId != null : !this$shipmentId.equals(other$shipmentId)) return false;
        final java.lang.Object this$documentType = this.getDocumentType();
        final java.lang.Object other$documentType = other.getDocumentType();
        if (this$documentType == null ? other$documentType != null : !this$documentType.equals(other$documentType)) return false;
        final java.lang.Object this$filePath = this.getFilePath();
        final java.lang.Object other$filePath = other.getFilePath();
        if (this$filePath == null ? other$filePath != null : !this$filePath.equals(other$filePath)) return false;
        final java.lang.Object this$submittedDate = this.getSubmittedDate();
        final java.lang.Object other$submittedDate = other.getSubmittedDate();
        if (this$submittedDate == null ? other$submittedDate != null : !this$submittedDate.equals(other$submittedDate)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ShipmentDocumentRequestDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $shipmentId = this.getShipmentId();
        result = result * PRIME + ($shipmentId == null ? 43 : $shipmentId.hashCode());
        final java.lang.Object $documentType = this.getDocumentType();
        result = result * PRIME + ($documentType == null ? 43 : $documentType.hashCode());
        final java.lang.Object $filePath = this.getFilePath();
        result = result * PRIME + ($filePath == null ? 43 : $filePath.hashCode());
        final java.lang.Object $submittedDate = this.getSubmittedDate();
        result = result * PRIME + ($submittedDate == null ? 43 : $submittedDate.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ShipmentDocumentRequestDTO(shipmentId=" + this.getShipmentId() + ", documentType=" + this.getDocumentType() + ", filePath=" + this.getFilePath() + ", submittedDate=" + this.getSubmittedDate() + ")";
    }

    public ShipmentDocumentRequestDTO() {
    }

    public ShipmentDocumentRequestDTO(final Integer shipmentId, final DocumentType documentType, final String filePath, final LocalDate submittedDate) {
        this.shipmentId = shipmentId;
        this.documentType = documentType;
        this.filePath = filePath;
        this.submittedDate = submittedDate;
    }
}

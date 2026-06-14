package com.cognizant.logitrack.dto;

import com.cognizant.logitrack.enums.DocumentStatus;
import com.cognizant.logitrack.enums.DocumentType;
import java.time.LocalDate;

public class ShipmentDocumentDTO {
    private Integer documentId;
    private Integer shipmentId;
    private DocumentType documentType;
    private String filePath;
    private LocalDate submittedDate;
    private DocumentStatus status;


    public static class ShipmentDocumentDTOBuilder {
        private Integer documentId;
        private Integer shipmentId;
        private DocumentType documentType;
        private String filePath;
        private LocalDate submittedDate;
        private DocumentStatus status;

        ShipmentDocumentDTOBuilder() {
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDocumentDTO.ShipmentDocumentDTOBuilder documentId(final Integer documentId) {
            this.documentId = documentId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDocumentDTO.ShipmentDocumentDTOBuilder shipmentId(final Integer shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDocumentDTO.ShipmentDocumentDTOBuilder documentType(final DocumentType documentType) {
            this.documentType = documentType;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDocumentDTO.ShipmentDocumentDTOBuilder filePath(final String filePath) {
            this.filePath = filePath;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDocumentDTO.ShipmentDocumentDTOBuilder submittedDate(final LocalDate submittedDate) {
            this.submittedDate = submittedDate;
            return this;
        }

        /**
         * @return {@code this}.
         */
        public ShipmentDocumentDTO.ShipmentDocumentDTOBuilder status(final DocumentStatus status) {
            this.status = status;
            return this;
        }

        public ShipmentDocumentDTO build() {
            return new ShipmentDocumentDTO(this.documentId, this.shipmentId, this.documentType, this.filePath, this.submittedDate, this.status);
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "ShipmentDocumentDTO.ShipmentDocumentDTOBuilder(documentId=" + this.documentId + ", shipmentId=" + this.shipmentId + ", documentType=" + this.documentType + ", filePath=" + this.filePath + ", submittedDate=" + this.submittedDate + ", status=" + this.status + ")";
        }
    }

    public static ShipmentDocumentDTO.ShipmentDocumentDTOBuilder builder() {
        return new ShipmentDocumentDTO.ShipmentDocumentDTOBuilder();
    }

    public Integer getDocumentId() {
        return this.documentId;
    }

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

    public DocumentStatus getStatus() {
        return this.status;
    }

    public void setDocumentId(final Integer documentId) {
        this.documentId = documentId;
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

    public void setStatus(final DocumentStatus status) {
        this.status = status;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof ShipmentDocumentDTO)) return false;
        final ShipmentDocumentDTO other = (ShipmentDocumentDTO) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$documentId = this.getDocumentId();
        final java.lang.Object other$documentId = other.getDocumentId();
        if (this$documentId == null ? other$documentId != null : !this$documentId.equals(other$documentId)) return false;
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
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof ShipmentDocumentDTO;
    }

    @java.lang.Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $documentId = this.getDocumentId();
        result = result * PRIME + ($documentId == null ? 43 : $documentId.hashCode());
        final java.lang.Object $shipmentId = this.getShipmentId();
        result = result * PRIME + ($shipmentId == null ? 43 : $shipmentId.hashCode());
        final java.lang.Object $documentType = this.getDocumentType();
        result = result * PRIME + ($documentType == null ? 43 : $documentType.hashCode());
        final java.lang.Object $filePath = this.getFilePath();
        result = result * PRIME + ($filePath == null ? 43 : $filePath.hashCode());
        final java.lang.Object $submittedDate = this.getSubmittedDate();
        result = result * PRIME + ($submittedDate == null ? 43 : $submittedDate.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ShipmentDocumentDTO(documentId=" + this.getDocumentId() + ", shipmentId=" + this.getShipmentId() + ", documentType=" + this.getDocumentType() + ", filePath=" + this.getFilePath() + ", submittedDate=" + this.getSubmittedDate() + ", status=" + this.getStatus() + ")";
    }

    public ShipmentDocumentDTO() {
    }

    public ShipmentDocumentDTO(final Integer documentId, final Integer shipmentId, final DocumentType documentType, final String filePath, final LocalDate submittedDate, final DocumentStatus status) {
        this.documentId = documentId;
        this.shipmentId = shipmentId;
        this.documentType = documentType;
        this.filePath = filePath;
        this.submittedDate = submittedDate;
        this.status = status;
    }
}

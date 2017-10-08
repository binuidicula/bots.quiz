package com.netreally.lex.models;

public class ResponseCard {

    private Integer version = 1;
    private String contentType = "application/vnd.amazonaws.card.generic";
    private GenericAttachment genericAttachments;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public GenericAttachment getGenericAttachments() {
        return genericAttachments;
    }

    public void setGenericAttachments(GenericAttachment genericAttachments) {
        this.genericAttachments = genericAttachments;
    }


}

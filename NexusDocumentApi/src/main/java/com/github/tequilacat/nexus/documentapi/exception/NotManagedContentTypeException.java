package com.github.tequilacat.nexus.documentapi.exception;

public class NotManagedContentTypeException extends NexusDocumentException {


    public NotManagedContentTypeException(String message) {
        super("NOT_MANAGED_CONTENT_TYPE", message);
    }

    public static String getErrorMessage(String contentType) {
        return "Dateien vom Typ " + contentType + " werden nicht unterstützt.";
    }

}
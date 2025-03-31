package com.github.tequilacat.nexus.documentapi.exception;

public class DocumentNotFoundDocumentException extends NexusDocumentException {

    public DocumentNotFoundDocumentException(String message) {
        super("DOCUMENT_NOT_FOUND", message);
    }
    public static final String DOCUMENT_NOT_FOUND = "Dokument konnte nicht gefunden werden";
    public static final String NO_UPLOADED_FILES = "Es konnten keine hochgeladenen Dateien gefunden werden";

    public static final String UPLOADED_FILE_NOT_FOUND = "Die hochgeladene Datei konnte nicht gefunden werden";

}
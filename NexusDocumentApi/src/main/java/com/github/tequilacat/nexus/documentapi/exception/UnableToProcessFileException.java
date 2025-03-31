package com.github.tequilacat.nexus.documentapi.exception;

public class UnableToProcessFileException extends NexusDocumentException {

    public UnableToProcessFileException(String message) {
        super("UNABLE_TO_WIRTE_FILE", message);
    }

    public static final String UNABLE_TO_ZIP = "Dateien konnten nicht gezippt werden";

    public static final String UNABLE_TO_WRITE = "Datei konnte nicht vollständig erstellt werden";

    public static final String UNABLE_TO_PROCESS = "Die hochgeladene Datei konnte nicht verarbeitet werden";

}

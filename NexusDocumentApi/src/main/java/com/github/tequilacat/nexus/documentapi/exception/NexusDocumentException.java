package com.github.tequilacat.nexus.documentapi.exception;

import lombok.Getter;

@Getter
public abstract class NexusDocumentException extends RuntimeException {

    private final String code;

    protected NexusDocumentException(String code, String message) {
        super(message);
        this.code = code;
    }

}
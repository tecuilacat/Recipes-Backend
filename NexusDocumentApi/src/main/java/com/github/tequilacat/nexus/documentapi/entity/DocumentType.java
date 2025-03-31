package com.github.tequilacat.nexus.documentapi.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum DocumentType {

    DOCUMENT_TYPE_TRANSCRIPT(Transcript.class, "Zeugnis")
    ;

    private final Class<?> clazz;
    private final String displayableName;

    public static DocumentType isInstanceOf(Document document) {
        return Arrays.stream(DocumentType.values())
                .filter(documentType -> documentType.getClazz().equals(document.getClass()))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(DocumentType.class, document.getClass().getName()));
    }

}

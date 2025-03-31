package com.github.tequilacat.nexus.documentapi.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ManagedType {

    PDF("application/pdf"),
    JPG("image/jpg"),
    JPEG("image/jpeg"),
    PNG("image/png")
    ;

    private final String contentType;

    public static boolean isManagedType(String contentType) {
        return Arrays.stream(ManagedType.values()).anyMatch(managedType -> StringUtils.equalsIgnoreCase(managedType.getContentType(), contentType));
    }

}
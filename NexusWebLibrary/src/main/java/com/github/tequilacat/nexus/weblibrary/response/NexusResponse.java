package com.github.tequilacat.nexus.weblibrary.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class NexusResponse {

    private final HttpStatus status;
    private String code;
    private String message;

}
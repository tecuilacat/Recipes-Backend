package com.github.tequilacat.nexus.weblibrary.response;

import org.springframework.http.HttpStatus;

public class Nexus403Response extends NexusResponse {

    public Nexus403Response() {
        super(HttpStatus.FORBIDDEN);
    }

}
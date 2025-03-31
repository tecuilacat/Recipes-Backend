package com.github.tequilacat.nexus.weblibrary.response;

import org.springframework.http.HttpStatus;

public class Nexus500Response extends NexusResponse {

    public Nexus500Response() {
        super(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
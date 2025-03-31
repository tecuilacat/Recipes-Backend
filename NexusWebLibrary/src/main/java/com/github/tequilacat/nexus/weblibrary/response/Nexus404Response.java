package com.github.tequilacat.nexus.weblibrary.response;

import org.springframework.http.HttpStatus;

public class Nexus404Response extends NexusResponse {

    public Nexus404Response() {
        super(HttpStatus.NOT_FOUND);
    }

}
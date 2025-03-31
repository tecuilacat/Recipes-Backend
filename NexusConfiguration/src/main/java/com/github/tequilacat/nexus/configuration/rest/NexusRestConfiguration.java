package com.github.tequilacat.nexus.configuration.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class NexusRestConfiguration implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        for (NexusBaseEndpoint nexusBaseEndpoint: NexusBaseEndpoint.values()) {
            configurer.addPathPrefix(nexusBaseEndpoint.getBasepath(), c -> nexusBaseEndpoint.getClazz().isAssignableFrom(c));
        }
    }

}
package com.github.tequilacat.nexus.configuration.rest;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

@Configuration
public class MultipartUploadConfig {

    @Value("${fileupload.max-file-size}")
    private long maxFileSize;

    @Value("${fileupload.max-file-size}")
    private long maxRequestSize;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofMegabytes(maxFileSize));
        factory.setMaxRequestSize(DataSize.ofMegabytes(maxRequestSize));
        return factory.createMultipartConfig();
    }

}
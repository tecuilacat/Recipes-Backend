package com.github.tequilacat.nexus.documentrestservice.documents.exception;

import com.github.tequilacat.nexus.documentrestservice.documents.controller.DocumentController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {DocumentController.class})
public class DocumentsExceptionHandler {



}
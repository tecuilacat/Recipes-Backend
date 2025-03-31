package com.github.tequilacat.nexus.documentrestservice.files.exception;

import com.github.tequilacat.nexus.documentapi.exception.DocumentNotFoundDocumentException;
import com.github.tequilacat.nexus.documentapi.exception.NexusDocumentException;
import com.github.tequilacat.nexus.documentapi.exception.NotManagedContentTypeException;
import com.github.tequilacat.nexus.documentapi.exception.UnableToProcessFileException;
import com.github.tequilacat.nexus.documentrestservice.files.delete.controller.DeleteFileController;
import com.github.tequilacat.nexus.documentrestservice.files.download.controller.DownloadFileController;
import com.github.tequilacat.nexus.documentrestservice.files.upload.controller.UploadFileController;
import com.github.tequilacat.nexus.weblibrary.response.Nexus403Response;
import com.github.tequilacat.nexus.weblibrary.response.Nexus404Response;
import com.github.tequilacat.nexus.weblibrary.response.Nexus500Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {DownloadFileController.class, UploadFileController.class, DeleteFileController.class})
public class FilesExceptionHandler {

    @ExceptionHandler(DocumentNotFoundDocumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Nexus404Response handleDocumentNotFoundDocumentException(NexusDocumentException nexusDocumentException) {
        Nexus404Response nexus404Response = new Nexus404Response();
        nexus404Response.setCode(nexusDocumentException.getCode());
        nexus404Response.setMessage(nexusDocumentException.getMessage());
        return nexus404Response;
    }

    @ExceptionHandler(NotManagedContentTypeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Nexus403Response handleNotManagedContentTypeException(NexusDocumentException nexusDocumentException) {
        Nexus403Response nexus403Response = new Nexus403Response();
        nexus403Response.setCode(nexusDocumentException.getCode());
        nexus403Response.setMessage(nexusDocumentException.getMessage());
        return nexus403Response;
    }

    @ExceptionHandler(UnableToProcessFileException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Nexus500Response handleUnableToProcessFileException(NexusDocumentException nexusDocumentException) {
        Nexus500Response nexus500Response = new Nexus500Response();
        nexus500Response.setCode(nexusDocumentException.getCode());
        nexus500Response.setMessage(nexusDocumentException.getMessage());
        return nexus500Response;
    }

}
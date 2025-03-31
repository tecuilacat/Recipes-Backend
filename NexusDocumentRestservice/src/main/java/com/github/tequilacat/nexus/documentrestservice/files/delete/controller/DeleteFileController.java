package com.github.tequilacat.nexus.documentrestservice.files.delete.controller;

import com.github.tequilacat.nexus.configuration.api.rest.NexusDocumentRestserviceController;
import com.github.tequilacat.nexus.documentrestservice.files.delete.service.DeleteFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("delete")
public class DeleteFileController implements NexusDocumentRestserviceController {

    private final DeleteFileService deleteFileService;

    @DeleteMapping("{uuid}")
    public void deleteFile(@PathVariable("uuid")UUID fileUuid) {
        deleteFileService.delete(fileUuid);
    }

}
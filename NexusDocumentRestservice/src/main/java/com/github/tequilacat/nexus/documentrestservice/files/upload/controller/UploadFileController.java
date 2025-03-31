package com.github.tequilacat.nexus.documentrestservice.files.upload.controller;

import com.github.tequilacat.nexus.configuration.api.rest.NexusDocumentRestserviceController;
import com.github.tequilacat.nexus.documentrestservice.files.upload.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("upload")
public class UploadFileController implements NexusDocumentRestserviceController {

    private final UploadFileService uploadFileService;

    @PostMapping
    public String uploadFile(
            @RequestParam("uuid") UUID documentUuid,
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "title", required = false) String title
    ) {
        return uploadFileService.uploadFile(documentUuid, file, title);
    }

}
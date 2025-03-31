package com.github.tequilacat.nexus.documentrestservice.files.download.controller;

import com.github.tequilacat.nexus.configuration.api.rest.NexusDocumentRestserviceController;
import com.github.tequilacat.nexus.documentrestservice.files.download.service.DownloadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("download")
public class DownloadFileController implements NexusDocumentRestserviceController {

    private final DownloadFileService downloadFileService;

    @GetMapping("file/{uuid}")
    public ResponseEntity<byte[]> downloadSingleFileByUuid(@PathVariable("uuid") UUID fileUuid) {
        return downloadFileService.downloadSingleFile(fileUuid);
    }

    @GetMapping("files/{uuid}")
    public ResponseEntity<byte[]> downloadMultipleFilesByUuid(@PathVariable("uuid") UUID documentUuid) {
        return downloadFileService.downloadMultipleFiles(documentUuid);
    }

}
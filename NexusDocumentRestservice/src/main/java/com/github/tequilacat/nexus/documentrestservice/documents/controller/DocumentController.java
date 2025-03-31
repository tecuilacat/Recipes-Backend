package com.github.tequilacat.nexus.documentrestservice.documents.controller;

import com.github.tequilacat.nexus.configuration.api.rest.NexusDocumentRestserviceController;
import com.github.tequilacat.nexus.documentapi.dto.DocumentOverviewDto;
import com.github.tequilacat.nexus.documentrestservice.documents.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("documents")
public class DocumentController implements NexusDocumentRestserviceController {

    private final DocumentService documentService;

    @GetMapping
    public DocumentOverviewDto getDocumentOverview() {
        return documentService.getOverview();
    }

}
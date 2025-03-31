package com.github.tequilacat.nexus.documentrestservice.documents.service;

import com.github.tequilacat.nexus.documentapi.dto.DocumentOverviewDto;
import com.github.tequilacat.nexus.documentapi.entity.Document;
import com.github.tequilacat.nexus.documentapi.entity.DocumentType;
import com.github.tequilacat.nexus.documentapi.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentOverviewDto getOverview() {
        List<Document> documents = documentRepository.findAll();
        for (Document document: documents) {
            document.setType(DocumentType.isInstanceOf(document).getDisplayableName());
        }
        return DocumentOverviewDto.builder()
                .documents(documents)
                .currentPage(0)
                .pages(1)
                .build();
    }

}
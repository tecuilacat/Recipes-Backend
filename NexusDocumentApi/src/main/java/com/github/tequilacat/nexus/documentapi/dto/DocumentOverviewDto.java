package com.github.tequilacat.nexus.documentapi.dto;

import com.github.tequilacat.nexus.documentapi.entity.Document;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DocumentOverviewDto {

    private int pages;

    private int currentPage;

    private List<Document> documents;

}

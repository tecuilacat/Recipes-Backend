package com.github.tequilacat.nexus.documentapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid = UUID.randomUUID();

    private String fileName;

    private String title;

    private String contentType;

    private long size;

    private LocalDateTime uploadDate;

    @JsonIgnore
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

}
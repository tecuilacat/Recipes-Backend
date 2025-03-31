package com.github.tequilacat.nexus.documentapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid = UUID.randomUUID();

    private String title;

    @Lob
    private String description;

    @Transient
    private String type;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UploadedFile> uploadedFiles = new ArrayList<>();

    public void addUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFiles.add(uploadedFile);
    }

}
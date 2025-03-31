package com.github.tequilacat.nexus.documentrestservice.files.upload.service;

import com.github.tequilacat.nexus.documentapi.entity.Document;
import com.github.tequilacat.nexus.documentapi.entity.UploadedFile;
import com.github.tequilacat.nexus.documentapi.exception.DocumentNotFoundDocumentException;
import com.github.tequilacat.nexus.documentapi.exception.NotManagedContentTypeException;
import com.github.tequilacat.nexus.documentapi.exception.UnableToProcessFileException;
import com.github.tequilacat.nexus.documentapi.repository.DocumentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadFileService {

    private final DocumentRepository documentRepository;

    private final UploadFileValidatorService uploadFileValidatorService;

    @Transactional
    public String uploadFile(
            @RequestParam("uuid") UUID documentUuid,
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title
    ) {
        if (!uploadFileValidatorService.validateFile(file)) {
            throw new NotManagedContentTypeException(NotManagedContentTypeException.getErrorMessage(file.getContentType()));
        }

        Optional<Document> optionalDocument = documentRepository.findByUuid(documentUuid);
        if (optionalDocument.isPresent()) {
            try {
                Document document = optionalDocument.get();
                UploadedFile uploadedFile = new UploadedFile();
                uploadedFile.setUploadDate(LocalDateTime.now());
                uploadedFile.setFileName(file.getOriginalFilename());
                uploadedFile.setData(file.getBytes());

                if (Objects.nonNull(title) && !title.isEmpty()) {
                    uploadedFile.setTitle(title);
                } else {
                    uploadedFile.setTitle(file.getOriginalFilename());
                }

                uploadedFile.setContentType(file.getContentType());
                uploadedFile.setSize(file.getSize());
                uploadedFile.setDocument(document);
                document.addUploadedFile(uploadedFile);
                documentRepository.save(document);
                return uploadedFile.getUuid().toString();
            } catch (IOException ioe) {
                throw new UnableToProcessFileException(UnableToProcessFileException.UNABLE_TO_PROCESS);
            }
        } else {
            throw new DocumentNotFoundDocumentException(DocumentNotFoundDocumentException.DOCUMENT_NOT_FOUND);
        }
    }

}
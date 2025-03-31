package com.github.tequilacat.nexus.documentrestservice.files.download.service;

import com.github.tequilacat.nexus.documentapi.entity.Document;
import com.github.tequilacat.nexus.documentapi.entity.UploadedFile;
import com.github.tequilacat.nexus.documentapi.exception.DocumentNotFoundDocumentException;
import com.github.tequilacat.nexus.documentapi.exception.UnableToProcessFileException;
import com.github.tequilacat.nexus.documentapi.repository.DocumentRepository;
import com.github.tequilacat.nexus.documentapi.repository.UploadedFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@RequiredArgsConstructor
public class DownloadFileService {

    private final DocumentRepository documentRepository;

    private final UploadedFileRepository uploadedFileRepository;

    public ResponseEntity<byte[]> downloadSingleFile(UUID fileUuid) {
        Optional<UploadedFile> optionalUploadedFile = uploadedFileRepository.findByUuid(fileUuid);
        if (optionalUploadedFile.isPresent()) {
            UploadedFile uploadedFile = optionalUploadedFile.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + uploadedFile.getFileName() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, uploadedFile.getContentType())
                    .body(uploadedFile.getData());
        } else {
            throw new DocumentNotFoundDocumentException(DocumentNotFoundDocumentException.DOCUMENT_NOT_FOUND);
        }
    }

    public ResponseEntity<byte[]> downloadMultipleFiles(UUID documentUuid) {
        Optional<Document> optionalDocument = documentRepository.findByUuid(documentUuid);
        if (optionalDocument.isPresent()) {
            Document document = optionalDocument.get();
            if (!document.getUploadedFiles().isEmpty()) {
                try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                     ZipOutputStream zipOut = new ZipOutputStream(baos)) {

                    for (UploadedFile uploadedFile : document.getUploadedFiles()) {
                        ZipEntry zipEntry = new ZipEntry(uploadedFile.getFileName());
                        zipOut.putNextEntry(zipEntry);
                        zipOut.write(uploadedFile.getData());
                        zipOut.closeEntry();
                    }

                    zipOut.finish();
                    byte[] zipBytes = baos.toByteArray();

                    String zipName = document.getTitle() != null && !document.getTitle().isEmpty()? document.getTitle() : "document";
                    zipName = zipName.replaceAll("\\s", "_");

                    return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + zipName + ".zip\"")
                            .header(HttpHeaders.CONTENT_TYPE, "application/zip")
                            .body(zipBytes);

                } catch (IOException e) {
                    throw new UnableToProcessFileException(UnableToProcessFileException.UNABLE_TO_ZIP);
                }
            } else {
                throw new DocumentNotFoundDocumentException(DocumentNotFoundDocumentException.NO_UPLOADED_FILES);
            }
        } else {
            throw new DocumentNotFoundDocumentException(DocumentNotFoundDocumentException.DOCUMENT_NOT_FOUND);
        }
    }

}
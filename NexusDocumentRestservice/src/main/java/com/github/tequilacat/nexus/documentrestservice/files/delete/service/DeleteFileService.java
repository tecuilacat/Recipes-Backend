package com.github.tequilacat.nexus.documentrestservice.files.delete.service;

import com.github.tequilacat.nexus.documentapi.entity.UploadedFile;
import com.github.tequilacat.nexus.documentapi.exception.DocumentNotFoundDocumentException;
import com.github.tequilacat.nexus.documentapi.repository.UploadedFileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteFileService {

    private final UploadedFileRepository uploadedFileRepository;

    @Transactional
    public void delete(UUID fileUuid) {
        Optional<UploadedFile> optionalUploadedFile = uploadedFileRepository.findByUuid(fileUuid);
        if (optionalUploadedFile.isPresent()) {
            uploadedFileRepository.delete(optionalUploadedFile.get());
        } else {
            throw new DocumentNotFoundDocumentException(DocumentNotFoundDocumentException.UPLOADED_FILE_NOT_FOUND);
        }
    }

}
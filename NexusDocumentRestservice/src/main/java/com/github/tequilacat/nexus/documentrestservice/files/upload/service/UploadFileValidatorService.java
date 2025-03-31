package com.github.tequilacat.nexus.documentrestservice.files.upload.service;

import com.github.tequilacat.nexus.documentapi.validation.ManagedType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileValidatorService {

    public boolean validateFile(MultipartFile multipartFile) {
        return ManagedType.isManagedType(multipartFile.getContentType());
    }

}
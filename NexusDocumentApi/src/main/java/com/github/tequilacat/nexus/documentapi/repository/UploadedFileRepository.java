package com.github.tequilacat.nexus.documentapi.repository;

import com.github.tequilacat.nexus.documentapi.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {

    Optional<UploadedFile> findByUuid(UUID uuid);

}
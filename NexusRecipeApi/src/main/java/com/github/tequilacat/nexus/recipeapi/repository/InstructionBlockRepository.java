package com.github.tequilacat.nexus.recipeapi.repository;

import com.github.tequilacat.nexus.recipeapi.entities.InstructionBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionBlockRepository extends JpaRepository<InstructionBlock, Long> { }
package com.github.tequilacat.recipes.recipes.database.repository;

import com.github.tequilacat.recipes.recipes.database.InstructionBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionBlockRepository extends JpaRepository<InstructionBlock, Long> { }
package com.github.tequilacat.nexus.recipeapi.repository;

import com.github.tequilacat.nexus.recipeapi.entities.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Page<Recipe> findAll(Pageable pageable);

    // Rezepte nach Kategorien mit Paginierung
    Page<Recipe> findByCategories_IdIn(List<Long> categoryIds, Pageable pageable);

    // Rezepte nach Name (Ignore Case) mit Paginierung
    Page<Recipe> findByNameIgnoreCaseContaining(String recipeName, Pageable pageable);

    // Rezepte nach Kategorie und Name (Ignore Case) mit Paginierung
    Page<Recipe> findByCategories_IdInAndNameIgnoreCaseContaining(List<Long> categoryIds, String recipeName, Pageable pageable);

    @Query("SELECT r.uuid FROM Recipe r")
    List<UUID> findAllUuids();

    Optional<Recipe> findByUuid(UUID uuid);

}
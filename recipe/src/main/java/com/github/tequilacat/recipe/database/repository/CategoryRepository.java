package com.github.tequilacat.recipe.database.repository;

import com.github.tequilacat.recipe.database.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNameIgnoreCase(String name);

    List<Category> findByNameIgnoreCaseContaining(String name);

}
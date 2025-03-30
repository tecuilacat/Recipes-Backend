package com.github.tequilacat.recipes.recipes.service;

import com.github.tequilacat.recipes.recipes.database.Category;
import com.github.tequilacat.recipes.recipes.database.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getCategoriesByName(String name) {
        return categoryRepository.findByNameIgnoreCaseContaining(name);
    }

    public Category saveCategory(Category category) {
        Optional<Category> optCategory = categoryRepository.findByNameIgnoreCase(category.getName());
        return optCategory.orElseGet(() -> categoryRepository.save(category));
    }

}

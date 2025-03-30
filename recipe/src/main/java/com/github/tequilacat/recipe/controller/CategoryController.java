package com.github.tequilacat.recipe.controller;

import com.github.tequilacat.recipe.database.Category;
import com.github.tequilacat.recipe.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("recipe/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories(@RequestParam(required = false) String categoryName) {
        if (categoryName != null && !categoryName.isEmpty()) {
            return categoryService.getCategoriesByName(categoryName);
        } else {
            return categoryService.getCategories();
        }
    }

    @PostMapping
    public Category saveCategory(Category category) {
        return categoryService.saveCategory(category);
    }

}
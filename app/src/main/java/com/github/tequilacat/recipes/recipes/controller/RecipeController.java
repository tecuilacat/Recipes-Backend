package com.github.tequilacat.recipes.recipes.controller;

import com.github.tequilacat.recipes.recipes.database.Recipe;
import com.github.tequilacat.recipes.recipes.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @Value("${recipe.random.default-amount}")
    private int defaultAmountOfRandomRecipes;

    @GetMapping
    public List<Recipe> getRecipes(
            @RequestParam(required = false) List<Long> categoryIds,
            @RequestParam(required = false) String recipeName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        int offset = page * size;

        List<Recipe> result;

        if (categoryIds != null && !categoryIds.isEmpty() && recipeName != null && !recipeName.isEmpty()) {
            result = recipeService.getByCategoriesAndName(categoryIds, recipeName, offset, size);
        } else if (categoryIds != null && !categoryIds.isEmpty()) {
            result = recipeService.getByCategories(categoryIds, offset, size);
        } else if (recipeName != null && !recipeName.isEmpty()) {
            result = recipeService.getByNameIgnoreCase(recipeName, offset, size);
        } else {
            result = recipeService.getRecipes(offset, size);
        }

        return result;
    }


    @GetMapping("{uuid}")
    public Recipe getRecipebyUuid(@PathVariable UUID uuid) {
        return new Recipe(); // TODO | OST | 30.03.2025 | muss noch implementiert werden
    }

    @GetMapping("random")
    public List<Recipe> getRandomRecipes(@RequestParam(required = false) Integer amount) {
        int finalAmount = defaultAmountOfRandomRecipes;
        if (amount != null && amount > 0) {
            finalAmount = amount;
        }
        return recipeService.getRandomRecipes(finalAmount);
    }

}
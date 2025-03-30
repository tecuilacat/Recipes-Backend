package com.github.tequilacat.recipes.recipes.service;

import com.github.tequilacat.recipes.recipes.database.Recipe;
import com.github.tequilacat.recipes.recipes.database.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final Random rand = new Random();

    private final RecipeRepository recipeRepository;

    public List<Recipe> getRecipes(int offset, int size) {
        PageRequest pageRequest = PageRequest.of(offset / size, size);
        return recipeRepository.findAll(pageRequest).getContent();
    }

    public List<Recipe> getByCategories(List<Long> categoryIds, int offset, int size) {
        PageRequest pageRequest = PageRequest.of(offset / size, size);
        return recipeRepository.findByCategories_IdIn(categoryIds, pageRequest).getContent();
    }

    public List<Recipe> getByNameIgnoreCase(String recipeName, int offset, int size) {
        PageRequest pageRequest = PageRequest.of(offset / size, size);
        return recipeRepository.findByNameIgnoreCaseContaining(recipeName, pageRequest).getContent();
    }

    public List<Recipe> getByCategoriesAndName(List<Long> categoryIds, String recipeName, int offset, int size) {
        PageRequest pageRequest = PageRequest.of(offset / size, size);
        return recipeRepository.findByCategories_IdInAndNameIgnoreCaseContaining(categoryIds, recipeName, pageRequest).getContent();
    }

    public List<Recipe> getRandomRecipes(int amount) {
        List<UUID> uuids = recipeRepository.findAllUuids();
        List<Recipe> result = new ArrayList<>();

        if (uuids == null || uuids.isEmpty()) {
            Collections.shuffle(result);
            return result;
        }

        if (uuids.size() <= amount) {
            for (UUID uuid : uuids) {
                Optional<Recipe> optRecipe = recipeRepository.findByUuid(uuid);
                optRecipe.ifPresent(result::add);
            }
            Collections.shuffle(result);
            return result;
        }

        Set<UUID> selectedUuids = new HashSet<>();

        while (selectedUuids.size() < amount) {
            int randomIndex = rand.nextInt(uuids.size());
            UUID randomUuid = uuids.get(randomIndex);

            selectedUuids.add(randomUuid);
        }

        for (UUID uuid : selectedUuids) {
            Optional<Recipe> optRecipe = recipeRepository.findByUuid(uuid);
            optRecipe.ifPresent(result::add);
        }

        Collections.shuffle(result);

        return result;
    }

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }



}

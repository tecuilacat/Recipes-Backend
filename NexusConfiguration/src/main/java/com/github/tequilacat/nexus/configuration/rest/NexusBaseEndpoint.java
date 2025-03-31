package com.github.tequilacat.nexus.configuration.rest;

import com.github.tequilacat.nexus.configuration.api.rest.NexusRecipeRestserviceController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NexusBaseEndpoint {

    NEXUS_RECIPE_RESTSERVICE("reciperestservice", NexusRecipeRestserviceController.class)
    ;

    private final String basepath;

    private final Class<?> clazz;

}
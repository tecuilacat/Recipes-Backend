package com.github.tequilacat.nexus.configuration.rest;

import com.github.tequilacat.nexus.configuration.api.rest.NexusDocumentRestserviceController;
import com.github.tequilacat.nexus.configuration.api.rest.NexusRecipeRestserviceController;
import com.github.tequilacat.nexus.configuration.api.rest.NexusSpotifyTrackerRestserviceController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NexusBaseEndpoint {

    NEXUS_RECIPE_RESTSERVICE("reciperestservice", NexusRecipeRestserviceController.class),
    NEXUS_SPOTIFY_TRACKER_RESTSERVICE("spotifytrackerrestservice", NexusSpotifyTrackerRestserviceController.class),
    NEXUS_DOCUMENT_RESTSERVICE("documentrestservice", NexusDocumentRestserviceController.class)
    ;

    private final String basepath;

    private final Class<?> clazz;

}
package com.github.tequilacat.nexus.reciperestservice.controller;

import com.github.tequilacat.nexus.configuration.api.rest.NexusRecipeRestserviceController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("test")
public class Testcontroller implements NexusRecipeRestserviceController {

    @GetMapping("ahh")
    public String test() {
        return "tut";
    }

}
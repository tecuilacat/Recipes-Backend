package com.github.tequilacat.nexus.recipeapi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private UUID uuid = UUID.randomUUID();

    private String name;

    @Lob
    private String description;

    private int duration;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InstructionBlock> instructionBlocks = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "recipe_category",  // Join-Tabelle
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();


    public void addInstructionBlock(InstructionBlock instructionBlock) {
        instructionBlock.setRecipe(this);
        instructionBlocks.add(instructionBlock);
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

}
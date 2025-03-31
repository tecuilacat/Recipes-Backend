package com.github.tequilacat.nexus.recipeapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class InstructionBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String header = "";

    @Lob
    private String instruction;

    private int duration = 0;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

}
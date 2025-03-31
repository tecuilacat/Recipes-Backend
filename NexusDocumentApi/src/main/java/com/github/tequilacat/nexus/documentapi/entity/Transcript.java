package com.github.tequilacat.nexus.documentapi.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@DiscriminatorValue("TRANSCRIPT")
@EqualsAndHashCode(callSuper = true)
public class Transcript extends Document {

    /**
     * company or school
     */
    private String organization;

}

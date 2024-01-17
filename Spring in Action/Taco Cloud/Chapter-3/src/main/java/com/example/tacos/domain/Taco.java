package com.example.tacos.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
//@EqualsAndHashCode(exclude = "createdOn")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tacoId;

    private Date createdOn = new Date();
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient taco) {
        this.ingredients.add(taco);
    }
}

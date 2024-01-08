package com.example.tacos.repository;

import com.example.tacos.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {
    List<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient saveIngredient(Ingredient ingredient);
}

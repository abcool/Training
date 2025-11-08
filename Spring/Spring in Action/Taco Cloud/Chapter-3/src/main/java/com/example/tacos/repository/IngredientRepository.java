package com.example.tacos.repository;

import com.example.tacos.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
   /* List<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient saveIngredient(Ingredient ingredient);*/
}

package com.example.tacos.repository;

import com.example.tacos.domain.Ingredient;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface IngredientRepository extends CassandraRepository<Ingredient, String> {
   /* List<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient saveIngredient(Ingredient ingredient);*/
}

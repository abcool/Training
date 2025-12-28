/*
package com.example.tacos.repository;

import com.example.tacos.domain.Ingredient;
import com.example.tacos.domain.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository{
    private JdbcTemplate jdbcTemplate;

    public IngredientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient",this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> ingredients = jdbcTemplate.query("select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient,
                id
                );
        return ingredients.size()==0?Optional.empty():Optional.of(ingredients.get(0));
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredient(id, name, type) values(?,?,?)",
                ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ingredient(
                resultSet.getString("id"),
                resultSet.getString("name"),
                Type.valueOf(resultSet.getString("type"))
        );
    }
}
*/

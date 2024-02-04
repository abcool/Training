package com.example.tacos.util;

import com.example.tacos.domain.Ingredient;
import com.example.tacos.domain.IngredientUDT;
import com.example.tacos.domain.Taco;
import com.example.tacos.domain.TacoUDT;

import java.util.List;
import java.util.stream.Collectors;

public class TacoURDUtils {
    public static TacoUDT toTacoUDT(Taco taco) {
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }

    public static List<IngredientUDT> toIngredientUDTs(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(ingredient -> toIngredientUDT(ingredient))
                .collect(Collectors.toList());
    }

    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }
}

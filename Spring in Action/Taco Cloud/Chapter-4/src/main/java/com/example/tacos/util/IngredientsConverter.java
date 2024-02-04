package com.example.tacos.util;

import com.example.tacos.domain.Ingredient;
import com.example.tacos.domain.IngredientUDT;
import com.example.tacos.domain.Type;
import com.example.tacos.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class IngredientsConverter implements Converter<String, IngredientUDT> {
    @Autowired
    private IngredientRepository ingredientRepository;

    //private Map<String, Ingredient> ingredientMap = new HashMap<>();

    /*public IngredientsConverter() {

        this.ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
        this.ingredientMap.put("COTO", new Ingredient("COTO","Corn Tortilla", Type.WRAP));
        this.ingredientMap.put("GRBF",new Ingredient("GRBF","Ground Beef", Type.PROTEIN));
        this.ingredientMap.put("CARN",new Ingredient("CARN","Carnitas",Type.PROTEIN));
        this.ingredientMap.put("TMTO",new Ingredient("TMTO","Diced Tomatoes",Type.VEGGIES));
        this.ingredientMap.put("LETC",new Ingredient("LETC","Lettuce",Type.VEGGIES));
        this.ingredientMap.put("CHED",new Ingredient("CHED","Cheddar",Type.CHEESE));
        this.ingredientMap.put("JACK",new Ingredient("JACK","Monterrey Jack",Type.CHEESE));
        this.ingredientMap.put("SLSA",new Ingredient("SLSA","Salsa",Type.SAUCE));
        this.ingredientMap.put("SRCR",new Ingredient("SRCR","Sour Cream",Type.SAUCE));
    }*/

    public IngredientsConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientUDT convert(String id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            return null;
        }

        return ingredient.map(i -> {
            return new IngredientUDT(i.getName(), i.getType());
        }).get();
    }
}

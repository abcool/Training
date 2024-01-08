package com.example.tacos.util;

import com.example.tacos.domain.Ingredient;
import com.example.tacos.domain.Type;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientsConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientsConverter() {

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
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}

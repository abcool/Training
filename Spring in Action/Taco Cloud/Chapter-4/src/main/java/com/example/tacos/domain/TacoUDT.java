package com.example.tacos.domain;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Data
@UserDefinedType(value = "taco")
public class TacoUDT {

    private final String name;
    private final List<IngredientUDT> ingredients;
}
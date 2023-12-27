package com.example.tacos.controller;

import com.example.tacos.domain.Ingredient;
import com.example.tacos.domain.Taco;
import com.example.tacos.domain.TacoOrder;
import com.example.tacos.domain.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping(path = "/designTaco")
@SessionAttributes(value = {"tacoOrder"})
public class TacoController {
    @ModelAttribute
    public void addIngredients(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO","Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF","Ground Beef", Type.PROTEIN),
                new Ingredient("CARN","Carnitas",Type.PROTEIN),
                new Ingredient("TMTO","Diced Tomatoes",Type.VEGGIES),
                new Ingredient("LETC","Lettuce",Type.VEGGIES),
                new Ingredient("CHED","Cheddar",Type.CHEESE),
                new Ingredient("JACK","Monterrey Jack",Type.CHEESE),
                new Ingredient("SLSA","Salsa",Type.SAUCE),
                new Ingredient("SRCR","Sour Cream",Type.SAUCE)
        );

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showForm(){
        return "designTaco";
    }
    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder){
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
        return ingredients.stream().filter(ingredient -> ingredient.getType().equals(type)).collect(Collectors.toList());
    }
}

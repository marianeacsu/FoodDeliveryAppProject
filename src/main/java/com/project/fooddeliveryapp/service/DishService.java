package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.Dish;
import com.project.fooddeliveryapp.model.Ingredient;
import com.project.fooddeliveryapp.repository.DishRepository;
import com.project.fooddeliveryapp.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {

    private DishRepository dishRepository;
    private IngredientRepository ingredientRepository;

    public DishService(DishRepository dishRepository, IngredientRepository ingredientRepository) {
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public Dish saveDish(Dish dish) {
        List<Ingredient> ingredientsFromDb = new ArrayList<>();
        for(Ingredient ingredient : dish.getIngredients()) {
            Ingredient ingredients = ingredientRepository.findById(ingredient.getId()).orElse(null);
            ingredientsFromDb.add(ingredients);
        }
        dish.setIngredients(ingredientsFromDb);
        return dishRepository.save(dish);
    }
}

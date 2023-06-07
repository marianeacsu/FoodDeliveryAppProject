package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.Ingredient;
import com.project.fooddeliveryapp.repository.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}

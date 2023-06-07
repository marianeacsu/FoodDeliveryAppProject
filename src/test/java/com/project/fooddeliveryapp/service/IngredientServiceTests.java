package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.Ingredient;
import com.project.fooddeliveryapp.model.User;
import com.project.fooddeliveryapp.repository.IngredientRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IngredientServiceTests {

    @Mock
    IngredientRepository ingredientRepository;

    @InjectMocks
    IngredientService ingredientService;

    @Test
    @DisplayName("Create ingredient")
    public void createIngredientShouldSucceed() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setName("Sare");
        when(ingredientRepository.save(ingredient)).thenReturn(ingredient);
        Ingredient result = ingredientService.saveIngredient(ingredient);
        assertEquals(ingredient.getId(), result.getId());
        assertEquals(ingredient.getName(), result.getName());
    }
}

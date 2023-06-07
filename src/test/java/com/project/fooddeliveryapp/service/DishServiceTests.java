package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.Dish;
import com.project.fooddeliveryapp.model.Ingredient;
import com.project.fooddeliveryapp.model.User;
import com.project.fooddeliveryapp.repository.DishRepository;
import com.project.fooddeliveryapp.repository.IngredientRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DishServiceTests {

    @Mock
    DishRepository dishRepository;
    @Mock
    IngredientRepository ingredientRepository;

    @InjectMocks
    DishService dishService;

    @Test
    @DisplayName("Create ingredient")
    public void createDishShouldSucceed() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setName("Sare");
        Dish dish = new Dish();
        dish.setDishName("Snitel");
        dish.setDishPrice(30);
        dish.setId(1);
        dish.setGrams(200);
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredient);
        dish.setIngredients(ingredientList);

        when(ingredientRepository.findById(1)).thenReturn(Optional.of(ingredient));
        when(dishRepository.save(dish)).thenReturn(dish);

        Dish result = dishService.saveDish(dish);
        assertEquals(dish.getId(), result.getId());
        assertEquals(dish.getDishPrice(), result.getDishPrice());
        assertEquals(dish.getDishName(), result.getDishName());
        assertEquals(dish.getGrams(), result.getGrams());
        assertEquals(dish.getIngredients(), result.getIngredients());
    }
}

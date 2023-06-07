package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.Dish;
import com.project.fooddeliveryapp.model.Ingredient;
import com.project.fooddeliveryapp.model.Restaurant;
import com.project.fooddeliveryapp.repository.DishRepository;
import com.project.fooddeliveryapp.repository.IngredientRepository;
import com.project.fooddeliveryapp.repository.RestaurantRepository;
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
public class RestaurantServiceTests {

    @Mock
    RestaurantRepository restaurantRepository;

    @Mock
    DishRepository dishRepository;
    @Mock
    IngredientRepository ingredientRepository;

    @InjectMocks
    RestaurantService restaurantService;

    @Test
    @DisplayName("Create restaurant")
    public void createRestaurantShouldSucceed() {
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

        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(1);
        restaurant.setName("Restaurant");
        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish);
        restaurant.setDishList(dishes);

        when(dishRepository.findById(1)).thenReturn(Optional.of(dish));
        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);

        Restaurant result = restaurantService.addRestaurant(restaurant);
        assertEquals(restaurant.getRestaurantId(), result.getRestaurantId());
        assertEquals(restaurant.getName(), result.getName());
        assertEquals(restaurant.getDishList(), result.getDishList());
    }

}

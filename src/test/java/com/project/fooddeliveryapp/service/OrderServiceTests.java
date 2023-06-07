package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.*;
import com.project.fooddeliveryapp.repository.*;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTests {

    @Mock
    OrderRepository orderRepository;
    @Mock
    IngredientRepository ingredientRepository;
    @Mock
    DishRepository dishRepository;
    @Mock
    UserRepository userRepository;

    @InjectMocks
    OrderService orderService;

    @Test
    @DisplayName("add order")
    public void createOrderShouldWork() {
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

        User user = new User();
        user.setId(1);
        user.setFirstName("Maria");
        user.setLastName("Neacsu");
        user.setPassword("Parola123");
        user.setUsername("marianeacsu");

        Order order = new Order();
        order.setPrice(200);
        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish);
        order.setDishes(dishes);
        order.setOrderId(1);
        order.setUser(user);

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(dishRepository.findById(1)).thenReturn(Optional.of(dish));

        when(orderRepository.save(order)).thenReturn(order);

        assertEquals(1, order.getOrderId());
        assertEquals(user, order.getUser());
        assertEquals(dishes, order.getDishes());
        assertEquals(200, order.getPrice());
    }
}

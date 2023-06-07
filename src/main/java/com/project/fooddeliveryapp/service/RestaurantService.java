package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.Dish;
import com.project.fooddeliveryapp.model.Ingredient;
import com.project.fooddeliveryapp.model.Restaurant;
import com.project.fooddeliveryapp.repository.DishRepository;
import com.project.fooddeliveryapp.repository.RestaurantRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private DishRepository dishRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, DishRepository dishRepository) {
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        List<Dish> dishesFromDb = new ArrayList<>();
        for(Dish dish : restaurant.getDishList()) {
            Dish dishes = dishRepository.findById(dish.getId()).orElseThrow(() -> new RuntimeException("Dish not found"));
            dishesFromDb.add(dishes);
        }
        restaurant.setDishList(dishesFromDb);
        return this.restaurantRepository.save(restaurant);
    }

    public Restaurant addDishesToRestaurant(Integer id, @NotNull List<Dish> dishes) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        List<Dish> dishesFromDb = restaurant.getDishList();
        for(Dish dish : dishes) {
            Dish dishToAdd = dishRepository.findById(dish.getId()).orElseThrow(() -> new RuntimeException("Dish not found"));;
            if(!dishesFromDb.contains(dishToAdd)) {
                dishesFromDb.add(dishToAdd);
            }
        }
        restaurant.setDishList(dishesFromDb);
        return this.restaurantRepository.save(restaurant);
    }

}

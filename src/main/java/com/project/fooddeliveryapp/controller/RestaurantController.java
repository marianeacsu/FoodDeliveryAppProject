package com.project.fooddeliveryapp.controller;

import com.project.fooddeliveryapp.model.Dish;
import com.project.fooddeliveryapp.model.Restaurant;
import com.project.fooddeliveryapp.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.addRestaurant(restaurant));
    }

    @PatchMapping("/addDishes/{id}")
    public ResponseEntity<Restaurant> addDishesToRestaurant(@PathVariable Integer id, @RequestBody List<Dish> dishes) {
        return ResponseEntity.ok(restaurantService.addDishesToRestaurant(id, dishes));
    }
}

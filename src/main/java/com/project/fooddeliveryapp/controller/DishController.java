package com.project.fooddeliveryapp.controller;

import com.project.fooddeliveryapp.model.Dish;
import com.project.fooddeliveryapp.service.DishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dish")
public class DishController {

    public final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping()
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        return ResponseEntity.ok(dishService.saveDish(dish));
    }
}

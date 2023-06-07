package com.project.fooddeliveryapp.controller;

import com.project.fooddeliveryapp.model.Dish;
import com.project.fooddeliveryapp.model.Order;
import com.project.fooddeliveryapp.model.Restaurant;
import com.project.fooddeliveryapp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
       return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PatchMapping("/addDishesToOrder/{id}")
    public ResponseEntity<Order> addDishesToOrder(@PathVariable Integer id, @RequestBody List<Dish> dishes) {
        return ResponseEntity.ok(orderService.addDishesToOrder(id, dishes));
    }
}

package com.project.fooddeliveryapp.service;

import com.project.fooddeliveryapp.model.*;
import com.project.fooddeliveryapp.repository.DishRepository;
import com.project.fooddeliveryapp.repository.OrderRepository;
import com.project.fooddeliveryapp.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private DishRepository dishRepository;
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, DishRepository dishRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.dishRepository = dishRepository;
    }

    public Order saveOrder(Order order) {
        List<Dish> dishFromDb = new ArrayList<>();
        int price = 0;
        for(Dish dish: order.getDishes()) {
            Dish dishes = dishRepository.findById(dish.getId()).orElse(null);
            dishFromDb.add(dishes);
            price = price + dishes.getDishPrice();
        }
        User user = userRepository.findById(order.getUser().getId()).orElse(null);
        order.setDishes(dishFromDb);
        order.setUser(user);
        order.setPrice(price);
        return orderRepository.save(order);
    }

    public Order addDishesToOrder(Integer id, @NotNull List<Dish> dishes) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));;
        List<Dish> dishesFromDb = order.getDishes();
        Integer price = order.getPrice();
        for(Dish dish : dishes) {
            Dish dishToAdd = dishRepository.findById(dish.getId()).orElseThrow(() -> new RuntimeException("Dish not found"));;
            if(!dishesFromDb.contains(dishToAdd)) {
                dishesFromDb.add(dishToAdd);
                price = price + dishToAdd.getDishPrice();
            }
        }
        order.setDishes(dishesFromDb);
        order.setPrice(price);
        return this.orderRepository.save(order);
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }



}

package com.project.fooddeliveryapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private int restaurantId;
    private String name;

    @ManyToMany
    @JoinTable(name = "restaurants_dishes_list", joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    public List<Dish> dishList;

    public Restaurant(int restaurantId, String name, List<Dish> dishList) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.dishList = dishList;
    }

    public Restaurant() {

    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", dishList=" + dishList +
                '}';
    }
}

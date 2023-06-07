package com.project.fooddeliveryapp.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dish_id")
    private int dishId;
    private String dishName;
    @Min(0)
    private int dishPrice;
    @Min(0)
    private int grams;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ingredients_dishes", joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;

    public Dish(int id, String dishName, int dishPrice, int grams, List<Ingredient> ingredients) {
        this.dishId = id;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.grams = grams;
        this.ingredients = ingredients;
    }

    public Dish() {

    }

    public int getId() {
        return dishId;
    }

    public void setId(int id) {
        this.dishId = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(int dishPrice) {
        this.dishPrice = dishPrice;
    }

    public int getGrams() {
        return grams;
    }

    public void setGrams(int grams) {
        this.grams = grams;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

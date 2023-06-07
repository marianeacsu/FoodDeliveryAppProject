package com.project.fooddeliveryapp.model;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id")
    private int ingredientId;
    private String name;

    public Ingredient(int id, String name) {
        this.ingredientId = id;
        this.name = name;
    }

    public Ingredient() {

    }

    public int getId() {
        return ingredientId;
    }

    public void setId(int id) {
        this.ingredientId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + ingredientId +
                ", name='" + name + '\'' +
                '}';
    }
}

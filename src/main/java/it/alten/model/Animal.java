package it.alten.model;

import java.time.LocalDate;

public abstract class Animal {

    public String name;

    public String favouriteFood;

    public Integer age;

    public LocalDate dateOfJoin;

    public Double weight;

    public Double height;

    public Animal(String name, String favouriteFood, Integer age, LocalDate dateOfJoin, Double weight, Double height) {
        this.name = name;
        this.favouriteFood = favouriteFood;
        this.age = age;
        this.dateOfJoin = dateOfJoin;
        this.weight = weight;
        this.height = height;
    }
}

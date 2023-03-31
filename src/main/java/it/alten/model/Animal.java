package it.alten.model;

import java.time.LocalDate;

public abstract class Animal {

    private String name;

    private String favouriteFood;

    private int age;

    private LocalDate dateOfJoin;

    private double weight;

    private double height;

    public Animal(String name, String favouriteFood, Integer age, LocalDate dateOfJoin, Double weight, Double height) {
        this.name = name;
        this.favouriteFood = favouriteFood;
        this.age = age;
        this.dateOfJoin = dateOfJoin;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}

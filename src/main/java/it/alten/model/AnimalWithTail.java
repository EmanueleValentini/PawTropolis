package it.alten.model;

import java.time.LocalDate;

public abstract class AnimalWithTail extends Animal{

    private double tailLenght;
    public AnimalWithTail(String name, String favouriteFood, Integer age, LocalDate dateOfJoin, Double weight,
                          Double height, double tailLenght) {
        super(name, favouriteFood, age, dateOfJoin, weight, height);
        this.tailLenght = tailLenght;
    }

    public double getTailLength() {
        return tailLenght;
    }

    public void setTailLength(Double tailLenght) {
        this.tailLenght = tailLenght;
    }
}

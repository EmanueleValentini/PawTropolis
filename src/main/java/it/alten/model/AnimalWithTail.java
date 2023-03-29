package it.alten.model;

import java.time.LocalDate;

public abstract class AnimalWithTail extends Animal{

    public Double tailLenght;
    public AnimalWithTail(String name, String favouriteFood, Integer age, LocalDate dateOfJoin, Double weight,
                          Double height, Double tailLenght) {
        super(name, favouriteFood, age, dateOfJoin, weight, height);
        this.tailLenght = tailLenght;
    }

    public Double getTailLenght() {
        return tailLenght;
    }

    public void setTailLenght(Double tailLenght) {
        this.tailLenght = tailLenght;
    }
}

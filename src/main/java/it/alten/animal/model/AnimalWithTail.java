package it.alten.animal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AnimalWithTail extends Animal{
    private double tailLength;
    private String name;

    private String favouriteFood;

    private int age;

    private LocalDate dateOfJoin;

    private double weight;

    private double height;

    public AnimalWithTail(String name, String favouriteFood, int age, LocalDate dateOfJoin, double weight, double height, double tailLength) {
        super(name, favouriteFood, age, dateOfJoin, weight, height);
        this.tailLength = tailLength;
    }
}

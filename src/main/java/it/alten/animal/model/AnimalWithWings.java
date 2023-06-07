package it.alten.animal.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AnimalWithWings extends Animal{
    private double wingspan;

    private String name;

    private String favouriteFood;

    private int age;

    private LocalDate dateOfJoin;

    private double weight;

    private double height;
    public AnimalWithWings(String name, String favouriteFood, int age, LocalDate dateOfJoin, double weight, double height, double wingspan) {
        super(name, favouriteFood, age, dateOfJoin, weight, height);
        this.wingspan = wingspan;
    }
}

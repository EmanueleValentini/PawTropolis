package it.alten.animal.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class AnimalWithTail extends Animal{
    private double tailLength;

    public AnimalWithTail(String name, String favouriteFood, int age, LocalDate dateOfJoin, double weight, double height, int id, double tailLength) {
        super(name, favouriteFood, age, dateOfJoin, weight, height, id);
        this.tailLength = tailLength;
    }
}

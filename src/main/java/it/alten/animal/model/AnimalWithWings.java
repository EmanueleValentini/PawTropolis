package it.alten.animal.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class AnimalWithWings extends Animal{
    private double wingspan;

    public AnimalWithWings(String name, String favouriteFood, int age, LocalDate dateOfJoin, double weight, double height, int id, double wingspan) {
        super(name, favouriteFood, age, dateOfJoin, weight, height, id);
        this.wingspan = wingspan;
    }
}

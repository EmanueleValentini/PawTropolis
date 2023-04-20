package it.alten.animal.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@Getter
@SuperBuilder
public abstract class Animal {

    private String name;

    private String favouriteFood;

    private int age;

    private LocalDate dateOfJoin;

    private double weight;

    private double height;

    @Override
    public String toString() {
        return name;

    }
}

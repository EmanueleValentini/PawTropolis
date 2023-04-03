package it.alten.animal.model;

import java.time.LocalDate;

public class Eagle extends AnimalWithWings{

    public Eagle(String name, String favouriteFood, Integer age, LocalDate dateOfJoin, Double weight, Double height, Double wingspan) {
        super(name, favouriteFood, age, dateOfJoin, weight, height, wingspan);
    }
}

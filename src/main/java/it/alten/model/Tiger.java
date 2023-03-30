package it.alten.model;

import java.time.LocalDate;

public class Tiger extends AnimalWithTail{

    public Tiger(String name, String favouriteFood, Integer age, LocalDate dateOfJoin, Double weight, Double height, Double tailLenght) {
        super(name, favouriteFood, age, dateOfJoin, weight, height, tailLenght);
    }
}

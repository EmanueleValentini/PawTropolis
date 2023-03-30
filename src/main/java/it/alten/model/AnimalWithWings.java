package it.alten.model;

import java.time.LocalDate;

public abstract class AnimalWithWings extends Animal{

    public Double wingspan;

    public AnimalWithWings(String name, String favouriteFood, Integer age, LocalDate dateOfJoin, Double weight, Double height, Double wingspan) {
        super(name, favouriteFood, age, dateOfJoin, weight, height);
        this.wingspan = wingspan;
    }

    public Double getWingspan() {
        return wingspan;
    }

    public void setWingspan(Double wingspan) {
        this.wingspan = wingspan;
    }
}

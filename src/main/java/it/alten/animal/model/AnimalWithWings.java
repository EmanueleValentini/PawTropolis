package it.alten.animal.model;

import java.time.LocalDate;

public abstract class AnimalWithWings extends Animal{

    private double wingspan;

    public AnimalWithWings(String name, String favouriteFood, Integer age, LocalDate dateOfJoin, Double weight, Double height, Double wingspan) {
        super(name, favouriteFood, age, dateOfJoin, weight, height);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(Double wingspan) {
        this.wingspan = wingspan;
    }
}

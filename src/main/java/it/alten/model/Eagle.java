package it.alten.model;

import java.time.LocalDate;

public class Eagle extends Animal{

    public Double wingspan;

    public Eagle(String name, String favouriteFood, Integer age, LocalDate dateOfJoin, Double weight,
                 Double height, Double wingspan) {
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

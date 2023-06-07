package it.alten.animal.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Double.compare(animal.weight, weight) == 0 && Double.compare(animal.height, height) == 0 && Objects.equals(name, animal.name) && Objects.equals(favouriteFood, animal.favouriteFood) && Objects.equals(dateOfJoin, animal.dateOfJoin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, favouriteFood, age, dateOfJoin, weight, height);
    }
}
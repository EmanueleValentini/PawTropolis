package it.alten.animal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@Getter
@SuperBuilder
@Entity
@NoArgsConstructor
public abstract class Animal {

    private String name;

    private String favouriteFood;

    private int age;

    private LocalDate dateOfJoin;

    private double weight;

    private double height;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @Override
    public String toString() {
        return name;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

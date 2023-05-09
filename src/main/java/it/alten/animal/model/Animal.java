package it.alten.animal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@SuperBuilder
@Entity
@NoArgsConstructor
public abstract class Animal implements Serializable {

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

}
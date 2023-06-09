package it.alten.animal.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LionDto {

    private String name;

    private String favouriteFood;

    private int age;

    private LocalDate dateOfJoin;

    private double weight;

    private double height;

    private double tailLength;

    private int idRoom;
}

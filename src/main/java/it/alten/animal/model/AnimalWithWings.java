package it.alten.animal.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class AnimalWithWings extends Animal{
    private double wingspan;
}

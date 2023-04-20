package it.alten.animal.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class AnimalWithTail extends Animal{
    private double tailLength;
}

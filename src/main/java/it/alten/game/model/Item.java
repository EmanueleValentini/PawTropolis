package it.alten.game.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Item {

    private String name;
    private String description;
    private int requestedSlots;


    @Override
    public String toString() {
        return name;
    }
}

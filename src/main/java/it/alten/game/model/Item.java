package it.alten.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int id;
    private String name;
    private String description;
    private int requestedSlots;

    public Item(String name, String description, int requestedSlots) {
        this.name = name;
        this.description = description;
        this.requestedSlots = requestedSlots;
    }




    @Override
    public String toString() {
        return name;
    }
}

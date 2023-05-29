package it.alten.game.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public abstract class Item {

    private String name;
    private String description;
    private int requestedSlots;


    @Override
    public String toString() {
        return name;
    }
}

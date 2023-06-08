package it.alten.game.model.dto;

import lombok.Data;

@Data
public abstract class ItemDto {

    private String name;

    private String description;

    private int requestedSlots;

    @Override
    public String toString() {
        return name;
    }
}

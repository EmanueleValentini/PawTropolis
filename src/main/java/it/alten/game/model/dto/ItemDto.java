package it.alten.game.model.dto;

import lombok.Data;

@Data
public class ItemDto {

    private String name;

    private String description;

    private int requestedSlots;

}

package it.alten.game.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class BagDto {

    private int availableSlots;

    private static int MAX_SLOTS;

    private int maxSlots;

    private List<Integer> idItems;
}

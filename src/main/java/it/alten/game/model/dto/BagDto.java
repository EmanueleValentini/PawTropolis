package it.alten.game.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class BagDto {

    private int availableSlots;

    private static final int MAX_SLOTS = 5;

    private final int maxSlots;

    private List<Integer> itemsInBagID;
}

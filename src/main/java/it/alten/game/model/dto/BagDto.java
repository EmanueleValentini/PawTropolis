package it.alten.game.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class BagDto {

    private int slots;

    private List<Integer> idItems;
}

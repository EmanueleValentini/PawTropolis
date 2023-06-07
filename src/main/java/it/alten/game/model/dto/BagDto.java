package it.alten.game.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class BagDto {

    private List<Integer> idItems;

    private int slots;

    private int idPlayer;
}

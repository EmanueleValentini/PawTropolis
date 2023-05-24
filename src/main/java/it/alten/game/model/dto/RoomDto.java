package it.alten.game.model.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class RoomDto {

    private String name;

    private List<Integer> item_ID;

    private List<Integer> animal_ID;

    private Map<Integer, Integer> adjacentRoom_ID;
}

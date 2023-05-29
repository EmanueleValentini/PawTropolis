package it.alten.game.model.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;


@Data
public class RoomDto {

    private String name;

    private List<Integer> idItem;

    private List<Integer> idAnimal;

    private Map<Integer, Integer> idAdjacentRoom;
}

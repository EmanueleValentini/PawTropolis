package it.alten.game.model.dto;

import lombok.Data;

import java.util.List;


@Data
public class RoomDto {

    private String name;

    private List<Integer> idItem;

    private List<Integer> idEagles;

    private List<Integer> idTigers;

    private List<Integer> idLions;

    private List<Integer> idAdjacentRoom;
}

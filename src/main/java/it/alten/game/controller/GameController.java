package it.alten.game.controller;

import it.alten.animal.model.Animal;
import it.alten.game.model.Bag;
import it.alten.game.model.Item;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.enums.AdjacentRooms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    private static final int DEFAULT_STARTING_LIFE_POINTS = 8;

    private final RoomController roomController;

    public GameController(RoomController roomController) {
        this.roomController = new RoomController();
    }

    public Room changeRoom(AdjacentRooms direction) {
        return RoomController.changeRoom(direction);
    }

    //  TODO: implementation of all controllers

    public void 



}

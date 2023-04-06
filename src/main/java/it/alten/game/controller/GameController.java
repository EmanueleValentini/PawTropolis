package it.alten.game.controller;

import it.alten.animal.model.Animal;
import it.alten.game.model.Bag;
import it.alten.game.model.Item;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.enums.AdjacentRooms;

import java.util.*;

public class GameController {

    private static final int DEFAULT_STARTING_LIFE_POINTS = 42;

    private final RoomController roomController;

    public GameController() {
        this.roomController = new RoomController();
    }

    public Room changeRoom(AdjacentRooms direction) {
        return RoomController.changeRoom(direction);
    }

    //  TODO: implementation of all controllers

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto a Pawtropolis come ti chiami?");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName,DEFAULT_STARTING_LIFE_POINTS);
        System.out.println(roomController.getCurrentRoom().roomDescription());
        System.out.println("Che vuoi fare?");
        String command = scanner.nextLine();
    }
}

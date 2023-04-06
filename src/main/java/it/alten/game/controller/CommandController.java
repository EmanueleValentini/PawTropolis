package it.alten.game.controller;

import it.alten.game.model.Bag;
import it.alten.game.model.Item;
import it.alten.game.model.Player;
import it.alten.game.model.enums.AdjacentRooms;

import java.util.function.Function;

public class CommandController {

    private String command;

    private final RoomController roomController;

    private final GameController gameController;

    public CommandController() {
        this.roomController = new RoomController();
        this.gameController = new GameController();
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void look() {
        System.out.println(roomController.getCurrentRoom().roomDescription() + "\n");
    }

    public void dropItem(Item item) {
        if (gameController.getPlayer().getAllItemsInBag().contains(item)) {
            gameController.getPlayer().removeItemFromBag(item);
            roomController.getCurrentRoom().addItemToRoom(item);
        } else {
            System.out.println("Sei n'cojone nun ce l'hai!");
        }
    }

    public void commandProcessing(String command) {
        if (command.equalsIgnoreCase("go north")) {
            if (gameController.changeRoom(AdjacentRooms.NORTH) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.NORTH);
                look();
            }

        } else if (command.equalsIgnoreCase("go south")) {
            if (gameController.changeRoom(AdjacentRooms.SOUTH) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.SOUTH);
                look();
            }

        } else if (command.equalsIgnoreCase("go east")) {
            if (gameController.changeRoom(AdjacentRooms.EAST) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.EAST);
                look();
            }

        } else if (command.equalsIgnoreCase("go west")) {
            if (gameController.changeRoom(AdjacentRooms.WEST) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.WEST);
                look();
            }

        } else if (command.equalsIgnoreCase("look")) {
            look();
        } else if (command.equalsIgnoreCase("bag")) {
            System.out.println(gameController.getPlayer().getAllItemsInBag());
        } else if (command.equalsIgnoreCase("drop " + roomController.getCurrentRoom().getRoomItemList()) {

        }
    }
}

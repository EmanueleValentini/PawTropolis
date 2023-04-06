package it.alten.game.controller;

import it.alten.game.model.enums.AdjacentRooms;

public class CommandController {

    private String command;

    private RoomController roomController;

    private GameController gameController;

    public CommandController() {

    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void commandProcessing(String command) {
        if (command.equalsIgnoreCase("go north") &&
                (roomController.getCurrentRoom().getAdjacentRoomsList().containsKey(AdjacentRooms.NORTH))){
                gameController.changeRoom(AdjacentRooms.NORTH);
                System.out.println(roomController.getCurrentRoom().roomDescription());

        }
        if (command.equalsIgnoreCase("go south") &&
                (roomController.getCurrentRoom().getAdjacentRoomsList().containsKey(AdjacentRooms.SOUTH))){
                gameController.changeRoom(AdjacentRooms.SOUTH);
                System.out.println(roomController.getCurrentRoom().roomDescription());

        }
        if (command.equalsIgnoreCase("go east") &&
                (roomController.getCurrentRoom().getAdjacentRoomsList().containsKey(AdjacentRooms.EAST))){
                gameController.changeRoom(AdjacentRooms.EAST);
                System.out.println(roomController.getCurrentRoom().roomDescription());

        }
        if (command.equalsIgnoreCase("go west") &&
                (roomController.getCurrentRoom().getAdjacentRoomsList().containsKey(AdjacentRooms.WEST))){
                gameController.changeRoom(AdjacentRooms.WEST);
                System.out.println(roomController.getCurrentRoom().roomDescription());

        }
    }
}

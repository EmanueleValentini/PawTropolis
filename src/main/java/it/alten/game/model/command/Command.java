package it.alten.game.model.command;

import it.alten.game.controller.RoomController;

public abstract class Command {

    private RoomController roomController;

    public Command() {
        this.roomController = RoomController.getInstance();
    }

    public RoomController getRoomController() {
        return roomController;
    }

    public void execute(){


    }


}

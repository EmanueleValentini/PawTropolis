package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;

public abstract class Command {

    private RoomController roomController;
    private GameController gameController;

    public Command() {
        this.roomController = RoomController.getInstance();
        this.gameController = GameController.getInstance();
    }

    public RoomController getRoomController() {
        return roomController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public abstract void execute(String command);

}

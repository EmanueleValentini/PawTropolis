package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;

public abstract class Command {

    private final RoomController roomController;
    private final GameController gameController;

    protected Command() {
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

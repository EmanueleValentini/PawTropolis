package it.alten.game.controller;

import it.alten.game.model.CommandFactory;

public class CommandController{

    private final RoomController roomController;

    private final GameController gameController;

    private final CommandFactory commandFactory;

    public CommandController() {
        this.roomController = RoomController.getInstance();
        this.gameController = GameController.getInstance();
        this.commandFactory = new CommandFactory();
    }

    public RoomController getRoomController() {
        return roomController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public CommandFactory getCommandFactory() {
        return commandFactory;
    }
}

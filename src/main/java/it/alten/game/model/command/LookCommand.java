package it.alten.game.model.command;

import it.alten.game.controller.RoomController;


public class LookCommand extends Command {

    private final RoomController roomController;

    public LookCommand() {

        this.roomController = getGameController().getRoomController();
    }

    @Override
    public void execute() {
        String description = roomController.getCurrentRoom().roomDescription() + "\n";
        System.out.println(description);
    }
}

package it.alten.game.model.command;

import it.alten.game.controller.RoomController;

public class LookCommand extends Command {

    @Override
    public void execute(String command) {
        String description = getRoomController().getCurrentRoom().roomDescription() + "\n";
        System.out.println(description);
    }
}

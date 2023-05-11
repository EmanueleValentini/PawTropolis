package it.alten.game.model.command;

import it.alten.game.controller.RoomController;

import java.util.Objects;


public class LookCommand extends Command {

    private final RoomController roomController;

    public LookCommand() {
        this.roomController = super.getGameController().getRoomController();
    }

    @Override
    public void execute() {
        String description = roomController.getCurrentRoom().roomDescription() + "\n";
        System.out.println(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LookCommand that = (LookCommand) o;
        return Objects.equals(roomController, that.roomController);
    }
}

package it.alten.game.model.command;

import it.alten.game.controller.RoomController;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component

public class LookCommand extends Command {

    private final RoomController roomController;

    public LookCommand() {

        this.roomController = RoomController.getInstance();
    }

    @Override
    public void execute() {
        String description = roomController.getCurrentRoom().roomDescription() + "\n";
        System.out.println(description);
    }
}

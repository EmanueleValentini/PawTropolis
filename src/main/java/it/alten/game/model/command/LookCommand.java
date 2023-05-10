package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends Command {

    private final RoomController roomController;

    @Autowired
    public LookCommand(GameController gameController) {
        super(gameController);
        this.roomController = getGameController().getRoomController();
    }

    @Override
    public void execute() {
        String description = roomController.getCurrentRoom().roomDescription() + "\n";
        System.out.println(description);
    }
}


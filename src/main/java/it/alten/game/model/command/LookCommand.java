package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.PlayerController;
import it.alten.game.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("look")
public class LookCommand extends Command {

    private final RoomService roomService;

    @Autowired
    public LookCommand(GameController gameController, RoomService roomService) {
        super(gameController);
        this.roomService = roomService;

    }

    @Override
    public void execute() {
        String description = getGameController().getRoomController().roomDescription();
        System.out.println(description);
    }
}


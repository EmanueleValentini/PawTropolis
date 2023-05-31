package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.PlayerController;
import it.alten.game.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("look")
public class LookCommand extends Command {

    RoomService roomService;
    private final PlayerController playerController;

    @Autowired
    public LookCommand(GameController gameController) {
        super(gameController);
        this.playerController = getGameController().getPlayerController();
    }

    @Override
    public void execute() {
        String description = roomService.findByPlayer(true) + "\n";
        System.out.println(description);
    }
}


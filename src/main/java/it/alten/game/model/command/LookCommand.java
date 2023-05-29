package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.PlayerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("look")
public class LookCommand extends Command {

    private final PlayerController playerController;

    @Autowired
    public LookCommand(GameController gameController) {
        super(gameController);
        this.playerController = getGameController().getPlayerController();
    }

    @Override
    public void execute() {
        String description = playerController.getCurrentRoom(gameController.getPlayer().getId()).roomDescription() + "\n";
        System.out.println(description);
    }
}


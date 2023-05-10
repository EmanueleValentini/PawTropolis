package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class QuitCommand extends Command {

    @Autowired
    public QuitCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        getGameController().setQuit(true);
    }
}

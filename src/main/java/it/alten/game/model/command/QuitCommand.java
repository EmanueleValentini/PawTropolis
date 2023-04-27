package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QuitCommand extends Command {

    @Override
    public void execute() {
        getGameController().setQuit(true);
    }
}

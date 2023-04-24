package it.alten.game.model.command;

import org.springframework.stereotype.Component;

@Component
public class QuitCommand extends Command {
    @Override
    public void execute() {
        getGameController().setQuit(true);
    }
}

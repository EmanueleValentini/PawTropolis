package it.alten.game.model.command;

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

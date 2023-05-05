package it.alten.game.model.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuitCommand extends Command {

    @Override
    public void execute() {
        getGameController().setQuit(true);
    }
}

package it.alten.game.model.command;

public class QuitCommand extends Command {
    @Override
    public void execute(String command) {
        getGameController().setQuit(true);
    }
}

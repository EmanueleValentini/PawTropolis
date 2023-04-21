package it.alten.game.model.command;

public class QuitCommand extends Command {
    @Override
    public void execute() {
        getGameController().setQuit(true);
    }

    @Override
    public String getTriggerName() {
        return "quit";
    }
}

package it.alten.game.model.command;

public class LookCommand extends Command {

    @Override
    public void execute() {
        String description = getGameController().getRoomController().getCurrentRoom().roomDescription() + "\n";
        System.out.println(description);
    }
}

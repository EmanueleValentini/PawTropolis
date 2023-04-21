package it.alten.game.model.command;


public class LookCommand extends Command {

    @Override
    public void execute() {
        String description = getRoomController().getCurrentRoom().roomDescription() + "\n";
        System.out.println(description);
    }

    @Override
    public String getTriggerName() {
        return "look";
    }
}

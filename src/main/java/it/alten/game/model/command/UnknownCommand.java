package it.alten.game.model.command;

public class UnknownCommand extends Command {

    public void execute(){
        System.out.println("Nun ho capito!");
    }

    @Override
    public String getTriggerName() {
        return null;
    }

}

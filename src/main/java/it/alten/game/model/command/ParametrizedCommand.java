package it.alten.game.model.command;

public abstract class ParametrizedCommand extends Command {

    public abstract void execute(String parameter);

}

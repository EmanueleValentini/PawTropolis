package it.alten.game.model;

import it.alten.game.model.command.*;

public class CommandFactory {

    private Command command;

    private ParametrizedCommand parametrizedCommand;
    public Command createCommandFromString(String input) {
        if (input.startsWith("go")) {
            String direction = input.replace("go","");
            return new GoCommand();
        } else if (input.startsWith("get")) {
            String itemToGet = input.replace("get","");
            return new GetCommand();
        } else if (input.startsWith("drop")) {
            String itemToDrop = input.replace("drop","");
            return new DropCommand();
        } else if (input.equalsIgnoreCase("look")) {
            return new LookCommand();
        } else if (input.equalsIgnoreCase("bag")) {
            return new BagCommand();
        } else if (input.equalsIgnoreCase("quit")) {
            return new QuitCommand();
        } else {
            return new UnknownCommand();
        }
    }
}

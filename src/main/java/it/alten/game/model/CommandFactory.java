package it.alten.game.model;

import it.alten.game.model.command.*;

public class CommandFactory {

    public Command createCommandFromString(String input) {
        if (input.startsWith("go")) {
            return new GoCommand();
        } else if (input.startsWith("get")) {
            return new GetCommand();
        } else if (input.startsWith("drop")) {
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

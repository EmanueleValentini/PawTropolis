package it.alten.game.model;

import it.alten.game.model.command.*;

public class CommandFactory {

    private static String parameter;

    public static String getParameter() {
        return parameter;
    }

    public static void setParameter(String parameter) {
        CommandFactory.parameter = parameter;
    }

    public Command createCommandFromString(String input) {
        if (input.startsWith("go")) {
            setParameter(input);
            return new GoCommand();
        } else if (input.startsWith("get")) {
            setParameter(input);
            return new GetCommand();
        } else if (input.startsWith("drop")) {
            setParameter(input);
            return new DropCommand();
        } else if (input.equalsIgnoreCase("look")) {
            setParameter(input);
            return new LookCommand();
        } else if (input.equalsIgnoreCase("bag")) {
            setParameter(input);
            return new BagCommand();
        } else if (input.equalsIgnoreCase("quit")) {
            setParameter(input);
            return new QuitCommand();
        } else {
            setParameter(input);
            return new UnknownCommand();
        }
    }
}

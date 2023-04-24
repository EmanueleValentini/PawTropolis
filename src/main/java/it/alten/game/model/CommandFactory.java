package it.alten.game.model;

import it.alten.game.model.command.*;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {

    public Command createCommandFromString(String input) {
        input = input.toLowerCase();
        if (input.startsWith("go")) {
            return new GoCommand(input);
        } else if (input.startsWith("get")) {
            return new GetCommand(input);
        } else if (input.startsWith("drop")) {
            return new DropCommand(input);
        } else if (input.startsWith("look")) {
            return new LookCommand();
        } else if (input.startsWith("bag")) {
            return new BagCommand();
        } else if (input.startsWith("quit")) {
            return new QuitCommand();
        } else {
            return new UnknownCommand();
        }
    }
}

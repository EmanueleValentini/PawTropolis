package it.alten.game.model;

import it.alten.game.model.command.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CommandFactory {
    private static final CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

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

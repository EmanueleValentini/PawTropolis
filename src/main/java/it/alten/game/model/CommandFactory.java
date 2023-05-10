package it.alten.game.model;

import it.alten.Application;
import it.alten.game.controller.GameController;
import it.alten.game.model.command.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CommandFactory {



    private ApplicationContext context;

    @Autowired
    private CommandFactory(ApplicationContext context) {

        this.context = context;

    }

    public Command createCommandFromString(String input) {
        input = input.toLowerCase();
        if (input.startsWith("go")) {
            return context.getBean(GoCommand.class);
        } else if (input.startsWith("get")) {
            return context.getBean(GetCommand.class);
        } else if (input.startsWith("drop")) {
            return context.getBean(DropCommand.class);
        } else if (input.startsWith("look")) {
            return context.getBean(LookCommand.class);
        } else if (input.startsWith("bag")) {
            return context.getBean(BagCommand.class);
        } else if (input.startsWith("quit")) {
            return context.getBean(QuitCommand.class);
        } else {
            return context.getBean(UnknownCommand.class);
        }
    }
}

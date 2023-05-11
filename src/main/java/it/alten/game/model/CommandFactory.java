package it.alten.game.model;

import it.alten.game.model.command.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@NoArgsConstructor
public class CommandFactory {


    protected Map<String, List<String>> commands;
    private ApplicationContext context;

    @Autowired
    private CommandFactory(ApplicationContext context) {
        this.context = context;
        this.commands = new HashMap<>();

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

    public Map<String, List<String>> commandMaker(String input) {
        List<String> tokens = List.of(input.split(" "));
        String commandName = tokens.get(0);
        List<String> parameters = tokens.subList(1, tokens.size());
        Map<String, List<String>> command = new HashMap<>();
        command.put(commandName, parameters);
        return command;
    }
}

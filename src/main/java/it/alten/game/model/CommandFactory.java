package it.alten.game.model;

import it.alten.game.model.command.*;
import it.alten.game.utils.CommandSetMaker;
import it.alten.game.utils.CommandTriggerMaker;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@NoArgsConstructor
@Data
public class CommandFactory {


    protected Map<String, List<String>> commands;

    private ApplicationContext context;

    private CommandSetMaker commandSet;

    private CommandTriggerMaker commandKeyWords;

    @Autowired
    private CommandFactory(ApplicationContext context, CommandSetMaker commandSet, CommandTriggerMaker commandKeyWords) {
        this.context = context;
        this.commands = new HashMap<>();
        this.commandKeyWords = commandKeyWords;
        this.commandSet = commandSet;

    }

    public Command createCommandFromString(String input) {
        input = input.toLowerCase();
        Map<String,List<String>> command = commandMaker(input);
        Command effectiveCommand = ;
        if (command.get(getKeyWord(input)).isEmpty()) {
            effectiveCommand = context.getBean(Command.class);
        } else {
            effectiveCommand = context.getBean(ParametrizedCommand.class);
        }
        return effectiveCommand;
    }

    public Map<String, List<String>> commandMaker(String input) {
        List<String> tokens = List.of(input.split(" "));
        String commandName = tokens.get(0);
        List<String> parameters = tokens.subList(1, tokens.size());
        Map<String, List<String>> command = new HashMap<>();
        command.put(commandName, parameters);
        return command;
    }

    public String getKeyWord(String input) {
        List<String> tokens = List.of(input.split(" "));
        return tokens.get(0);
    }
}

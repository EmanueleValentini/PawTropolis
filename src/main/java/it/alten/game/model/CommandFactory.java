package it.alten.game.model;

import it.alten.game.model.command.Command;
import it.alten.game.model.command.ParametrizedCommand;
import it.alten.game.model.command.UnknownCommand;
import it.alten.game.utils.CommandSetMaker;
import it.alten.game.utils.CommandTriggerSetMaker;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@NoArgsConstructor
@Data
public class CommandFactory {


    protected Map<String, List<String>> commands;

    private ApplicationContext context;

    private CommandSetMaker commandSetOrigin;

    private CommandTriggerSetMaker commandKeyWords;

    private Map<String, Class<? extends Command>> commandMap;

    @Autowired
    private CommandFactory(ApplicationContext context, CommandSetMaker commandSet, CommandTriggerSetMaker commandKeyWords) {
        this.context = context;
        this.commands = new HashMap<>();
        this.commandKeyWords = commandKeyWords;
        this.commandSetOrigin = commandSet;
        this.commandMap = init();
    }

    public Map<String,Class<? extends Command>> init () {
        Set<String> commandTrigger = commandKeyWords.getCommandTriggerSet();
        Set<Class<? extends Command>> commandSet = commandSetOrigin.getCommandSet();
        List<String> commandTriggerList = new ArrayList<>(commandTrigger);
        List<Class <? extends Command>> commandList = new ArrayList<>(commandSet);
        Map<String,Class<? extends Command>> commandPairs = new HashMap<>();
        for (int i = 0; i < commandSet.size(); i++) {
            commandPairs.put(commandTriggerList.get(i),commandList.get(i));
        }
        return commandPairs;
    }

    public Command createCommandFromString(String input) {
        input = input.toLowerCase();
        commands = commandMaker(input);
        List<String> parameters = getParameters(input);
        Command actualCommand;

        try {
            actualCommand = (Command) context.getBean(getKeyWord(input));
            if (actualCommand instanceof ParametrizedCommand) {
                ((ParametrizedCommand) actualCommand).setParameters(parameters);
            } else {
                actualCommand = (Command) context.getBean(getKeyWord(input));
            }
        } catch (Exception e) {
            actualCommand = context.getBean(UnknownCommand.class);
        }
        return actualCommand;
    }

    public Map<String, List<String>> commandMaker(String input) {
        Map<String, List<String>> command = new HashMap<>();
        command.put(getKeyWord(input), getParameters(input));
        return command;
    }

    public String getKeyWord(String input) {
        List<String> tokens = List.of(input.split(" "));
        return tokens.get(0);
    }

    public List<String> getParameters(String input) {
        List<String> tokens = List.of(input.split(" "));
        return tokens.subList(1, tokens.size());
    }
}

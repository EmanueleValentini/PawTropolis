package it.alten.game.model;

import it.alten.game.model.command.*;
import it.alten.utils.CommandSetMaker;
import it.alten.utils.CommandTriggerMaker;

import java.util.*;

public class CommandFactory {
    private static CommandFactory instance;
    private Map<String,Class<? extends Command>> commands;

    private CommandFactory() {
        commands = init();
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Map<String,Class<? extends Command>> init () {
        Set<String> commandTrigger = CommandTriggerMaker.getInstance().getCommandTriggerSet();
        Set<Class<? extends Command>> commandSet = CommandSetMaker.getInstance().getCommandSet();
        List<String> commandTriggerList = new ArrayList<>(commandTrigger);
        List<Class <? extends Command>> commandList = new ArrayList<>(commandSet);
        Map<String,Class<? extends Command>> commandPairs = new HashMap<>();
        for (int i = 0; i < commandSet.size(); i++) {
            commandPairs.put(commandTriggerList.get(i),commandList.get(i));
        }
        return commandPairs;
    }


    //TODO: Risolvere createCommandFromString, come faccio a recuperarmi la prima chiave della mappa?
    public Command createCommandFromString(String input) {
        Map<String,List<String>> commandData = inputSplitter(input);
        
    }

    private Map<String, List<String>> inputSplitter(String input) {
        List<String> tokens = List.of(input.split(" "));
        String commandName = tokens.get(0);
        List<String> parameters = tokens.subList(1, tokens.size());
        Map<String, List<String>> command = new HashMap<>();
        command.put(commandName, parameters);
        return command;
    }
}

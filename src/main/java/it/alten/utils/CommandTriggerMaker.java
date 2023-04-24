package it.alten.utils;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class CommandTriggerMaker {

    private static CommandTriggerMaker instance;

    private final Set<String> commandTriggerSet;

    public static CommandTriggerMaker getInstance() {
        if (instance == null) {
            instance = new CommandTriggerMaker();
        }
        return instance;
    }

    private CommandTriggerMaker() {
        commandTriggerSet = init();
    }

    public Set<String> init() {
        Set<String> commandTrigger = new HashSet<>();
        commandTrigger.add("bag");
        commandTrigger.add("drop");
        commandTrigger.add("get");
        commandTrigger.add("go");
        commandTrigger.add("look");
        commandTrigger.add("quit");
        commandTrigger.add(null);
        return commandTrigger;
    }
}

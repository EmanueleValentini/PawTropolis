package it.alten.utils;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class CommandTriggerMaker {
    private static CommandTriggerMaker instance;

    private final List<String> commandTriggerList;

    public static CommandTriggerMaker getInstance() {
        if (instance == null) {
            instance = new CommandTriggerMaker();
        }
        return instance;
    }

    private CommandTriggerMaker() {
        commandTriggerList = init();
    }

    public List<String> init() {
        List<String> commandTrigger = new ArrayList<>();
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

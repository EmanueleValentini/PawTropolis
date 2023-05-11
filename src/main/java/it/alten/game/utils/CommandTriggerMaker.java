package it.alten.game.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Data
@Component
public class CommandTriggerMaker {

    private final Set<String> commandTriggerSet;

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

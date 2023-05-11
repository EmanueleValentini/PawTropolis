package it.alten.utils;


import it.alten.game.model.command.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public final class CommandSetMaker {

    private final Set<Class<? extends Command>> commandSet;

    private CommandSetMaker() {
        commandSet = init();
    }

    public Set<Class<? extends Command>> init() {
        Set<Class<? extends Command>> commandClasses = new HashSet<>();
        commandClasses.add(BagCommand.class);
        commandClasses.add(DropCommand.class);
        commandClasses.add(GetCommand.class);
        commandClasses.add(GoCommand.class);
        commandClasses.add(LookCommand.class);
        commandClasses.add(QuitCommand.class);
        commandClasses.add(UnknownCommand.class);
        return commandClasses;
    }
}

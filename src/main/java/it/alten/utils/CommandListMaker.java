package it.alten.utils;


import it.alten.game.model.command.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class CommandListMaker {
    private static CommandListMaker instance;

    private final List<Class<? extends Command>> commandList;

    public static CommandListMaker getInstance() {
        if (instance == null) {
            instance = new CommandListMaker();
        }
        return instance;
    }

    private CommandListMaker() {
        commandList = init();
    }

    public List<Class<? extends Command>> init() {
        List<Class<? extends Command>> commandClasses = new ArrayList<>();
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

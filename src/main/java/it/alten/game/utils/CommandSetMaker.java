package it.alten.game.utils;


import it.alten.game.model.command.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Data
@Component
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
        commandClasses.add(MoriCommand.class);
        commandClasses.add(DajeCommand.class);
        commandClasses.add(UnknownCommand.class);
        return commandClasses;
    }
}

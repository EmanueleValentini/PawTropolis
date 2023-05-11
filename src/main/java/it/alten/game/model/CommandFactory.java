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

    //TODO: Crea i set di keyword e classi che devono essere istanziate, crea un controllo se la List è vuota per capire se è un command o un parametrizedCommand
    public Command createCommandFromString(String input) {
        input = input.toLowerCase();
        Map<String,List<String>> command = commandMaker(input);

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

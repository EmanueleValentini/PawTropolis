package it.alten.game.model.command;

import org.springframework.stereotype.Component;

@Component
public class UnknownCommand extends Command {

    public void execute(){
        System.out.println("Nun ho capito!");
    }

}

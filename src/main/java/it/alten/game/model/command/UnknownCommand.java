package it.alten.game.model.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class UnknownCommand extends Command {

    public void execute(){
        System.out.println("Nun ho capito!");
    }

}

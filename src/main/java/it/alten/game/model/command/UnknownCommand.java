package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UnknownCommand extends Command {

    public void execute(){
        System.out.println("Nun ho capito!");
    }

}

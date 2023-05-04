package it.alten.game.model.command;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class UnknownCommand extends Command {

    public void execute(){
        System.out.println("Nun ho capito!");
    }

}

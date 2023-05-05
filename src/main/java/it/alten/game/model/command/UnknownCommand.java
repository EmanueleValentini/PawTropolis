package it.alten.game.model.command;

import lombok.AllArgsConstructor;



@AllArgsConstructor
public class UnknownCommand extends Command {

    public void execute(){
        System.out.println("Nun ho capito!");
    }

}

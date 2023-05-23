package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mori")
public class MoriCommand extends Command{

    @Autowired
    public MoriCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        System.out.println("Ma vattelapijan'derculo mori te!!!");
    }
}

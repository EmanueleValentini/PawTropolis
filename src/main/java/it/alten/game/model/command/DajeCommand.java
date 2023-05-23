package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("daje")
public class DajeCommand extends Command{

    @Autowired
    public DajeCommand(GameController gameController) {
        super(gameController);
    }
    @Override
    public void execute() {
        System.out.println("DAJE ROMA DAJE, ER SAMBUCONE MOLIARI CURATIVO!!! YAYAHOOOOOOOOOO!");
    }
}

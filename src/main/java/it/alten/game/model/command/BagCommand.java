package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class BagCommand extends Command {

    @Autowired
    public BagCommand(GameController gameController) {
        super(gameController);
    }


    @Override
    public void execute() {
        if (getGameController().getPlayer().getAllItemsInBag().isEmpty()) {
            System.out.println("Non hai un cazzo");
        } else {
            System.out.println(getGameController().getPlayer().getAllItemsInBag());
        }
    }
}

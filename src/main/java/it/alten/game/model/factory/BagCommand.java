package it.alten.game.model.factory;

import it.alten.game.controller.GameController;

public class BagCommand extends Command {

    private GameController gameController;

    @Override
    public void execute() {
        if (gameController.getPlayer().getAllItemsInBag().isEmpty()) {
            System.out.println("Non hai un cazzo");
        } else {
            System.out.println(gameController.getPlayer().getAllItemsInBag());
        }
    }
}

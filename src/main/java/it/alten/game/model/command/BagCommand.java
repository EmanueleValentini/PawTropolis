package it.alten.game.model.command;

import it.alten.game.controller.GameController;

public class BagCommand extends Command {

    @Override
    public void execute(String command) {
        if (getGameController().getPlayer().getAllItemsInBag().isEmpty()) {
            System.out.println("Non hai un cazzo");
        } else {
            System.out.println(getGameController().getPlayer().getAllItemsInBag());
        }
    }
}

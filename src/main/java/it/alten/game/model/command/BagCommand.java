package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.ItemInBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("bag")
public class BagCommand extends Command {

    @Autowired
    public BagCommand(GameController gameController) {
        super(gameController);
    }


    @Override
    public void execute() {
        List<ItemInBag> inventory = getGameController().getBagController().getInventory(getGameController().getPlayer().getBag());
        if (inventory.isEmpty()) {
            System.out.println("Non hai un cazzo");
        } else {
            System.out.println(inventory);
        }
    }
}

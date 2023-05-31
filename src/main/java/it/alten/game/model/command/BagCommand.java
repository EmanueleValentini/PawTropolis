package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.ItemInBag;
import it.alten.game.service.ItemInBagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("bag")
public class BagCommand extends Command {

    private final ItemInBagService itemInBagService;

    @Autowired
    public BagCommand(GameController gameController, ItemInBagService itemInBagService) {
        super(gameController);
        this.itemInBagService = itemInBagService;
    }


    @Override
    public void execute() {
        List<ItemInBag> inventory = itemInBagService.findAll();
        if (inventory.isEmpty()) {
            System.out.println("Non hai un cazzo");
        } else {
            System.out.println(inventory);
        }
    }
}

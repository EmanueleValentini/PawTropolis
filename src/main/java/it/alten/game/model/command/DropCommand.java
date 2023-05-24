package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.Item;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.ItemInRoom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Component("drop")
public class DropCommand extends ParametrizedCommand {
    @Autowired
    protected DropCommand(GameController gameController) {
        super(gameController);
    }

    protected DropCommand(GameController gameController, List<String> parameters) {
        super(gameController,parameters);
    }

    @Override
    public void execute() {
        String itemToDrop = String.join(" ",parameters);
        if(findItem(itemToDrop) != null){
            dropItem(findItem(itemToDrop));
            System.out.println("Hai droppato " + itemToDrop);
        } else {
            System.out.println("E dove lo avresti?");
        }
    }

    public void dropItem(Item item) {
        if (getGameController().getPlayer().getAllItemsInBag().contains(item)) {
            getGameController().getPlayer().removeItemFromBag((ItemInBag) item);
            getGameController().getRoomController().getCurrentRoom().addItemToRoom((ItemInRoom) item);
        }
    }

    public Item findItem(String itemToDrop) {
        Item itemFound;
        List<ItemInBag> bagItemList = getGameController().getPlayer().getAllItemsInBag();
        for (Item itemInTheBag : bagItemList) {
            if (itemInTheBag.getName().equalsIgnoreCase(itemToDrop)) {
                itemFound = itemInTheBag;
                return itemFound;
            }
        }
        return null;
    }
}

package it.alten.game.model.command;

import it.alten.game.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DropCommand extends Command {

    private String input;


    @Override
    public void execute() {
        String itemToDrop = input.replace("drop ", "");
        if(findItem(itemToDrop) != null){
            dropItem(findItem(itemToDrop));
            System.out.println("Hai droppato " + itemToDrop);
        } else {
            System.out.println("E dove lo avresti?");
        }
    }


    public void dropItem(Item item) {
        if (getGameController().getPlayer().getAllItemsInBag().contains(item)) {
            getGameController().getPlayer().removeItemFromBag(item);
            getGameController().getRoomController().getCurrentRoom().addItemToRoom(item);
        }
    }
    public Item findItem(String itemToDrop) {
        Item itemFound = null;
        List<Item> bagItemList = getGameController().getPlayer().getAllItemsInBag();
        for (Item itemInTheBag : bagItemList) {
            if (itemInTheBag.getName().equals(itemToDrop)) {
                itemFound = itemInTheBag;
                return itemFound;
            }
        }
        return itemFound;
    }

}

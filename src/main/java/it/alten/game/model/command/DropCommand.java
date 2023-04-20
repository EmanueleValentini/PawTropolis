package it.alten.game.model.command;

import it.alten.game.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DropCommand extends Command {

    private String input;


    @Override
    public void execute() {
        String itemToDrop = input.replace("drop ", "");
        Item itemFound = null;
        for (Item itemInTheBag : getGameController().getPlayer().getAllItemsInBag()) {
            if (itemInTheBag.getName().equalsIgnoreCase(itemToDrop)) {
                dropItem(itemInTheBag);
                System.out.println("Hai droppato " + itemInTheBag.getName());
                itemFound = itemInTheBag;
                break;
            }
        }
        if (itemFound == null) {
            System.out.println("Nun ce l'hai faggiano!");
        }
    }


    public void dropItem(Item item) {
        if (getGameController().getPlayer().getAllItemsInBag().contains(item)) {
            getGameController().getPlayer().removeItemFromBag(item);
            getRoomController().getCurrentRoom().addItemToRoom(item);
        }
    }
}

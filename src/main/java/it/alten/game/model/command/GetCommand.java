package it.alten.game.model.command;

import it.alten.game.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetCommand extends Command {

    private String input;


    @Override
    public void execute() {
        String itemToGet = input.replace("get ", "");
        Item itemFound = null;
        List<Item> itemList = getRoomController().getCurrentRoom().getRoomItemList();

        if (!getGameController().getPlayer().getBag().isFull()) {
            for (Item itemInTheRoom : itemList) {

                if (itemInTheRoom.getName().equalsIgnoreCase(itemToGet)) {
                    if(getItem(itemInTheRoom)) {
                        System.out.println("Hai preso " + itemInTheRoom.getName());
                        itemFound = itemInTheRoom;
                        break;
                    }
                    else {
                        System.out.println("Non ci entra");
                        itemFound = itemInTheRoom;
                    }
                }


            }
        }


        if (itemFound == null) {
            System.out.println("Dove cazzo lo hai visto??? Ti prego dimmelo!!!");
        }

    }

    public boolean getItem(Item item) {
        if (getRoomController().getCurrentRoom().getRoomItemList().contains(item)) {
            getRoomController().getCurrentRoom().removeItemFromRoom(item);
            getGameController().getPlayer().addItemToBag(item);
            return true;
        }

        return false;
    }
}

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
                    if (getItem(itemInTheRoom)) {
                        System.out.println("Hai preso " + itemInTheRoom.getName());
                        itemFound = itemInTheRoom;
                        break;
                    } else {
                        System.out.println("Non ci entra");
                        itemFound = itemInTheRoom;

                    }

                } else {
                    System.out.println("Sei cieco ma non slovacco");

                }


            }
        } else {
            System.out.println("La borsa è piena");
        }


    }

    public boolean getItem(Item item) {
        boolean hasHappened = false;
        if (getRoomController().getCurrentRoom().getRoomItemList().contains(item)) {
            hasHappened = getGameController().getPlayer().addItemToBag(item);

            if (hasHappened) {
                getRoomController().getCurrentRoom().removeItemFromRoom(item);
            }

        }

        return hasHappened;
    }
}

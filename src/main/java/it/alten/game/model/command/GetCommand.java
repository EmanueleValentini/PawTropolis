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
<<<<<<< HEAD
                if (itemInTheRoom.getName().equalsIgnoreCase(itemToGet) && (getItem(itemInTheRoom))) {
                    itemFound = itemInTheRoom;
                    break;
=======

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

>>>>>>> 1f985f978a1961987de91cc2a39f31a1c56a3d45
                }
            }
<<<<<<< HEAD
            if (itemFound != null) {
                System.out.println("Hai preso " + itemFound.getName());
            } else if (itemFound == null) {
                System.out.println("Dove lo hai visto??? Ti prego dimmelo!!!");
            } else if (getGameController().getPlayer().getBag().isFull() && itemFound != null) {
                System.out.println("Hai la borsa piena!");
            }
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

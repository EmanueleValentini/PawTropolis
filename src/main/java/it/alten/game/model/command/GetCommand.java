package it.alten.game.model.command;

import it.alten.game.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@AllArgsConstructor
public class GetCommand extends Command {

    private String input;

    @Override
    public void execute() {
        String itemToGet = input.replace("get ", "");

        if (getGameController().getPlayer().getBag().isSlotsAvailable()) {
            if (findItem(itemToGet) != null) {
                Item itemPresentToGet = findItem(itemToGet);
                if (getItem(itemPresentToGet)){
                    System.out.println("Hai preso " + itemToGet);
                } else {
                    System.out.println(itemToGet + " Non entra nella borsa");
                }
            } else {
                System.out.println("Non c'è");
            }
        } else {
            System.out.println("La borsa è piena");
        }

    }

    public boolean getItem(Item item) {
        if (getGameController().getRoomController().getCurrentRoom().getRoomItemList().contains(item) &&
                (getGameController().getPlayer().addItemToBag(item))){
                getGameController().getRoomController().getCurrentRoom().removeItemFromRoom(item);
                return true;
        }
        return false;
    }

    public Item findItem(String itemToGet) {
        Item itemFound;
        List<Item> roomItemList = getGameController().getRoomController().getCurrentRoom().getRoomItemList();
        for (Item itemInTheRoom : roomItemList) {
            if (itemInTheRoom.getName().equals(itemToGet)) {
                itemFound = itemInTheRoom;
                return itemFound;
            }
        }
        return null;
    }
}

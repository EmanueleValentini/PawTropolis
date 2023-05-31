package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.ItemInBagController;
import it.alten.game.controller.ItemInRoomController;
import it.alten.game.controller.RoomController;
import it.alten.game.model.ItemInRoom;
import it.alten.game.model.dto.ItemInBagDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Component("get")
public class GetCommand extends ParametrizedCommand {

    private final ItemInRoomController itemInRoomController;

    private final ItemInBagController itemInBagController;

    private  final RoomController roomController;

    @Autowired
    public GetCommand(GameController gameController, ItemInRoomController itemInRoomController, ItemInBagController itemInBagController, RoomController roomController) {
        super(gameController);

        this.itemInRoomController = itemInRoomController;
        this.itemInBagController = itemInBagController;
        this.roomController = roomController;
    }

    public GetCommand(GameController gameController, List<String> parameters, ItemInRoomController itemInRoomController, ItemInBagController itemInBagController, RoomController roomController) {
        super(gameController,parameters);

        this.itemInRoomController = itemInRoomController;
        this.itemInBagController = itemInBagController;
        this.roomController = roomController;
    }

    @Override
    public void execute() {
        String itemToGet = String.join(" ",parameters);
        if (getGameController().getBagController().findById(1).getAvailableSlots() > 0) {
            if (findItem(itemToGet) != null) {
                ItemInRoom itemPresentToGet = findItem(itemToGet);
                if (getItem(itemPresentToGet) &&
                        itemPresentToGet.getRequestedSlots() < getGameController().getBagController().findById(1).getAvailableSlots()){
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

    public boolean getItem(ItemInRoom item) {
        List<ItemInRoom> availableItems = itemInRoomController.findByRoom(roomController.findByPlayer(true));
        if (availableItems.get(0).toString().equals("excalibur")){
            itemInBagController.save(item);
            itemInRoomController.deleteById(item.getId());
            return true;
        }
        return false;
    }

    public ItemInRoom findItem(String itemToDrop) {
        ItemInRoom itemFound;
        List<ItemInRoom> roomItemList = itemInRoomController.findByRoom(roomController.findByPlayer(true));
        for (ItemInRoom itemInTheRoom : roomItemList) {
            if (itemInTheRoom.getName().equalsIgnoreCase(itemToDrop)) {
                itemFound = itemInTheRoom;
                return itemFound;
            }
        }
        return null;
    }
}

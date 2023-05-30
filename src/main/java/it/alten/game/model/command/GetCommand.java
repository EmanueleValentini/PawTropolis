package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.ItemInRoom;
import it.alten.game.model.Room;
import it.alten.game.model.dto.ItemInBagDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter

@NoArgsConstructor
@Component("get")
public class GetCommand extends ParametrizedCommand {

    @Autowired
    public GetCommand(GameController gameController) {
        super(gameController);
    }

    public GetCommand(GameController gameController, List<String> parameters) {
        super(gameController,parameters);
    }

    @Override
    public void execute() {
        String itemToGet = String.join(" ",parameters);
        if (getGameController().getPlayer().getBag().getAvailableSlots() > 0) {
            if (findItem(itemToGet) != null) {
                ItemInRoom itemPresentToGet = findItem(itemToGet);
                if (getItem(itemPresentToGet) &&
                        itemPresentToGet.getRequestedSlots() < getGameController().getPlayer().getBag().getAvailableSlots()){
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
        List<ItemInRoom> availableItems = getGameController().getPlayer().getRoom().getRoomItemList();
        if (availableItems.contains(item)){
            ModelMapper modelMapper = new ModelMapper();
            ItemInBagDto itemToGet = modelMapper.map(item, ItemInBagDto.class);
            gameController.getItemInBagController().getItemInBagService().save(itemToGet);
            gameController.getItemInRoomController().getItemInRoomService().deleteById(item.getId());
            return true;
        }
        return false;
    }

    public ItemInRoom findItem(String itemToDrop) {
        ItemInRoom itemFound;
        Room room = getGameController().getPlayer().getRoom();
        List<ItemInRoom> roomItemList = room.getRoomItemList();
        for (ItemInRoom itemInTheRoom : roomItemList) {
            if (itemInTheRoom.getName().equalsIgnoreCase(itemToDrop)) {
                itemFound = itemInTheRoom;
                return itemFound;
            }
        }
        return null;
    }
}

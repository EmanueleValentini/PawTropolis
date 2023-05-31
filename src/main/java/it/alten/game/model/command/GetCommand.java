package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.ItemInRoom;
import it.alten.game.model.Room;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.service.ItemInBagService;
import it.alten.game.service.ItemInRoomService;
import it.alten.game.service.RoomService;
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

    private final ItemInRoomService itemInRoomService;

    private final ItemInBagService itemInBagService;

    private  final RoomService roomService;

    @Autowired
    public GetCommand(GameController gameController, ItemInBagService itemInBagService, ItemInRoomService itemInRoomService, RoomService roomService) {
        super(gameController);
        this.itemInRoomService = itemInRoomService;
        this.itemInBagService = itemInBagService;
        this.roomService = roomService;
    }

    public GetCommand(GameController gameController, List<String> parameters, ItemInBagService itemInBagService, ItemInRoomService itemInRoomService, RoomService roomService) {
        super(gameController,parameters);
        this.itemInRoomService = itemInRoomService;
        this.itemInBagService = itemInBagService;
        this.roomService = roomService;
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
        List<ItemInRoom> availableItems = itemInRoomService.findAllByRoom(roomService.findByPlayer(true));
        if (availableItems.contains(item)){
            ModelMapper modelMapper = new ModelMapper();
            ItemInBagDto itemToGet = modelMapper.map(item, ItemInBagDto.class);
            itemInBagService.save(itemToGet);
            itemInRoomService.deleteById(item.getId());
            return true;
        }
        return false;
    }

    public ItemInRoom findItem(String itemToDrop) {
        ItemInRoom itemFound;
        List<ItemInRoom> roomItemList = itemInRoomService.findAllByRoom(roomService.findByPlayer(true));
        for (ItemInRoom itemInTheRoom : roomItemList) {
            if (itemInTheRoom.getName().equalsIgnoreCase(itemToDrop)) {
                itemFound = itemInTheRoom;
                return itemFound;
            }
        }
        return null;
    }
}

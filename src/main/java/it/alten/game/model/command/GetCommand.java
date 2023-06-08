package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.Room;
import it.alten.game.model.dto.BagDto;
import it.alten.game.model.dto.ItemInRoomDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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
        BagDto bagDto = getGameController().getBagController().findById(1);
        if (bagDto.getSlots() > 0) {
            if (findItem(itemToGet) != null) {
                ItemInRoomDto itemPresentToGet = findItem(itemToGet);
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

    public boolean getItem(ItemInRoomDto item) {
        int bagSlots = gameController.getBagController().findById(1).getSlots();
        int occupiedSlots = gameController.getItemInBagController().sumFields();
        if (occupiedSlots < bagSlots && (bagSlots - occupiedSlots >= item.getRequestedSlots())) {
                gameController.getItemInBagController().save(item);
                gameController.getItemInRoomController().deleteByName(item.getName());
                return true;
        }
        return false;
    }

    public ItemInRoomDto findItem(String itemToDrop) {
        Room room = gameController.getRoomController().findByIsPlayerInTrue();
        return gameController.getItemInRoomController().findByRoomAndName(room,itemToDrop);
    }
}

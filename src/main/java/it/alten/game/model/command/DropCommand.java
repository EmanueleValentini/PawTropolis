package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.ItemInBagController;
import it.alten.game.controller.ItemInRoomController;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.service.ItemInRoomService;
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
@Component("drop")
public class DropCommand extends ParametrizedCommand {

    private final ItemInBagController itemInBagController;

    private final ItemInRoomController itemInRoomController;

    @Autowired
    protected DropCommand(GameController gameController, ItemInBagController itemInBagController, ItemInRoomController itemInRoomController) {
        super(gameController);


        this.itemInBagController = itemInBagController;
        this.itemInRoomController = itemInRoomController;
    }

    protected DropCommand(GameController gameController, List<String> parameters, ItemInBagController itemInBagController, ItemInRoomController itemInRoomController) {
        super(gameController,parameters);

        this.itemInBagController = itemInBagController;
        this.itemInRoomController = itemInRoomController;

    }

    @Override
    public void execute() {
        String itemToDrop = String.join(" ",parameters);
        if(findItem(itemToDrop) != null){
            dropItem(findItem(itemToDrop));
            System.out.println("Hai droppato " + itemToDrop);
        } else {
            System.out.println("E dove lo avresti?");
        }
    }

    public void dropItem(ItemInBag item) {
        List<ItemInBag> inventory = itemInBagController.findAll();
        if (inventory.contains(item)){
            itemInRoomController.save(item);
            itemInBagController.deleteById(item.getId());
        }
    }

    public ItemInBag findItem(String itemToDrop) {
        ItemInBag itemFound;
        List<ItemInBag> bagItemList = itemInBagController.findAll();
        for (ItemInBag itemInTheBag : bagItemList) {
            if (itemInTheBag.getName().equalsIgnoreCase(itemToDrop)) {
                itemFound = itemInTheBag;
                return itemFound;
            }
        }
        return null;
    }
}

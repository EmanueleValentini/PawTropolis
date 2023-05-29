package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.Bag;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemDto;
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
    @Autowired
    protected DropCommand(GameController gameController) {
        super(gameController);
    }

    protected DropCommand(GameController gameController, List<String> parameters) {
        super(gameController,parameters);
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

    public boolean dropItem(ItemInBag item) {
        List<ItemInBag> inventory = getGameController().getBagController().getInventory(getGameController().getPlayer().getBag());
        if (inventory.contains(item)){
            ModelMapper modelMapper = new ModelMapper();
            ItemDto itemToDrop = modelMapper.map(item, ItemDto.class);
            gameController.getItemInRoomController().getItemInRoomService().save(itemToDrop);
            gameController.getItemInBagController().getItemInBagService().deleteById(item.getId());
            return true;
        }
        return false;
    }

    public ItemInBag findItem(String itemToDrop) {
        ItemInBag itemFound;
        Bag bag = getGameController().getPlayer().getBag();
        List<ItemInBag> bagItemList = bag.getInventory();
        for (ItemInBag itemInTheBag : bagItemList) {
            if (itemInTheBag.getName().equalsIgnoreCase(itemToDrop)) {
                itemFound = itemInTheBag;
                return itemFound;
            }
        }
        return null;
    }
}

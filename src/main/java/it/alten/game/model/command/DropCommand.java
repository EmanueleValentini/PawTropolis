package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.dto.ItemInBagDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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

    public void dropItem(ItemInBagDto item) {
        gameController.getItemInRoomController().save(item);
        gameController.getItemInBagController().deleteByName(item.getName());
    }

    public ItemInBagDto findItem(String itemToDrop) {
        return gameController.getItemInBagController().findByName(itemToDrop);
    }
}

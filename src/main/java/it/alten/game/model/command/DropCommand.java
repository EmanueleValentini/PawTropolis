package it.alten.game.model.command;

import it.alten.game.model.Item;

public class DropCommand extends ParametrizedCommand {
    @Override
    public void execute(String parameter) {
        String itemToDrop = parameter.replace("drop ","");
        for (Item itemInTheBag : getGameController().getPlayer().getAllItemsInBag()) {
            if (itemInTheBag.getName().equalsIgnoreCase(itemToDrop)) {
                dropItem(itemInTheBag);
                System.out.println("Hai droppato " + itemInTheBag.getName());
                break;
            }
        }
    }


    public void dropItem(Item item) {
        if (getGameController().getPlayer().getAllItemsInBag().contains(item)) {
            getGameController().getPlayer().removeItemFromBag(item);
            getRoomController().getCurrentRoom().addItemToRoom(item);
        }
    }
}

package it.alten.game.model.command;

import it.alten.game.model.Item;

import static it.alten.game.model.CommandFactory.getParameter;

public class GetCommand extends Command {

    @Override
    public void execute() {
        String parameter = getParameter();
        String itemToGet = parameter.replace("get ","");
        for (Item itemInTheRoom : getRoomController().getCurrentRoom().getRoomItemList()) {
                if (itemInTheRoom.getName().equalsIgnoreCase(itemToGet)) {
                    getItem(itemInTheRoom);
                    System.out.println("Hai preso " + itemInTheRoom.getName());
                    break;
                } else {
                    System.out.println("Dove cazzo lo hai visto??? Ti prego dimmelo!!!");
                }
        }
    }

    public void getItem(Item item) {
       if (getRoomController().getCurrentRoom().getRoomItemList().contains(item)) {
            getRoomController().getCurrentRoom().removeItemFromRoom(item);
            getGameController().getPlayer().addItemToBag(item);
       }
    }
}

package it.alten.game.model.command;

import it.alten.game.model.Item;

public class GetCommand extends Command {

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public GetCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute() {
        String itemToGet = input.replace("get ","");
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

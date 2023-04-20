package it.alten.game.model.command;

import it.alten.game.model.Item;

public class DropCommand extends Command {

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public DropCommand(String input) {
        this.input = input;
    }
    @Override
    public void execute() {
        String itemToDrop = input.replace("drop ","");
        for (Item itemInTheBag : getGameController().getPlayer().getAllItemsInBag()) {
            if (itemInTheBag.getName().equalsIgnoreCase(itemToDrop)) {
                dropItem(itemInTheBag);
                System.out.println("Hai droppato " + itemInTheBag.getName());
                break;
            } else {
                System.out.println("Nun ce l'hai faggiano!");
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

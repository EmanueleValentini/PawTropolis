package it.alten.game.controller;

import it.alten.game.model.Item;
import it.alten.game.model.enums.AdjacentRooms;

public class CommandController {

    private String command;

    private final RoomController roomController;

    private final GameController gameController;

    public CommandController(GameController gameController) {
        this.roomController = new RoomController();
        this.gameController = gameController;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void look() {
        System.out.println(roomController.getCurrentRoom().roomDescription() + "\n");
    }

    public void dropItem(Item item) {
        if (gameController.getPlayer().getAllItemsInBag().contains(item)) {
            gameController.getPlayer().removeItemFromBag(item);
            roomController.getCurrentRoom().addItemToRoom(item);
        }
    }

    public void getItem(Item item) {
        if (roomController.getCurrentRoom().getRoomItemList().contains(item)) {
            roomController.getCurrentRoom().removeItemFromRoom(item);
            gameController.getPlayer().addItemToBag(item);
        }
    }

    public void commandProcessing(String command) {

        if (command.equalsIgnoreCase("go north")) {
            if (gameController.changeRoom(AdjacentRooms.NORTH) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.NORTH);
                look();
            }

        } else if (command.equalsIgnoreCase("go south")) {
            if (gameController.changeRoom(AdjacentRooms.SOUTH) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.SOUTH);
                look();
            }

        } else if (command.equalsIgnoreCase("go east")) {
            if (gameController.changeRoom(AdjacentRooms.EAST) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.EAST);
                look();
            }

        } else if (command.equalsIgnoreCase("go west")) {
            if (gameController.changeRoom(AdjacentRooms.WEST) == null) {
                System.out.println("Coglione non c'è una porta su quel lato");
            } else {
                gameController.changeRoom(AdjacentRooms.WEST);
                look();
            }

        } else if (command.equalsIgnoreCase("look")) {
            look();
        } else if (command.equalsIgnoreCase("bag")) {
            if (gameController.getPlayer().getAllItemsInBag().isEmpty()) {
                System.out.println("Non hai un cazzo");
            } else {
                System.out.println(gameController.getPlayer().getAllItemsInBag());
            }
        } else if (command.startsWith("drop")) {
            String itemToDrop = command.substring(5).trim();
            if (itemToDrop != null) {
                for (Item itemInTheBag : gameController.getPlayer().getAllItemsInBag()) {
                    if (itemInTheBag.getName().equalsIgnoreCase(itemToDrop)) {
                        dropItem(itemInTheBag);
                        System.out.println("Hai droppato " + itemInTheBag.getName());
                        break;
                    } else {
                        System.out.println("Scrivi bene!");
                    }
                }
            } else {
                System.out.println("Sei n'cojone nun ce l'hai!");
            }

        } else if (command.startsWith("get")) {
            String itemToGet = command.substring(4).trim();
            if (itemToGet != null) {
                for (Item itemInTheRoom : roomController.getCurrentRoom().getRoomItemList()) {
                    if (itemInTheRoom.getName().equalsIgnoreCase(itemToGet)) {
                        getItem(itemInTheRoom);
                        System.out.println("Hai preso " + itemInTheRoom.getName());
                        break;
                    } else {
                        System.out.println("Scrivi bene!");
                    }
                }
            } else {
                System.out.println("E da ndo cazzo lo piji?");
            }
        } else if (command.equalsIgnoreCase("quit")) {
            gameController.setQuit(true);
        } else {
            System.out.println("Nun ho capito, ripeti!");
        }
    }
}

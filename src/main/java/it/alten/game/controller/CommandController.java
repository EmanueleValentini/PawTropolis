package it.alten.game.controller;

import it.alten.game.model.CommandFactory;
import it.alten.game.model.Item;
import it.alten.game.model.enums.Direction;
import it.alten.game.model.command.Command;

public class CommandController{

    private String command;

    private final RoomController roomController;

    private final GameController gameController;

    private final CommandFactory commandFactory;

    public CommandController() {
        this.roomController = RoomController.getInstance();
        this.gameController = GameController.getInstance();
        this.commandFactory = new CommandFactory();
    }

    public void commandProcesser (String input){
        commandFactory.createCommandFromString(input).execute();
    }

//
//    public String getCommand() {
//        return command;
//    }
//
//    public void setCommand(String command) {
//        this.command = command;
//    }
//
//    public void look() {
//        System.out.println(roomController.getCurrentRoom().roomDescription() + "\n");
//    }
//
//    public void dropItem(Item item) {
//        if (gameController.getPlayer().getAllItemsInBag().contains(item)) {
//            gameController.getPlayer().removeItemFromBag(item);
//            roomController.getCurrentRoom().addItemToRoom(item);
//        }
//    }
//
//    public void getItem(Item item) {
//        if (roomController.getCurrentRoom().getRoomItemList().contains(item)) {
//            roomController.getCurrentRoom().removeItemFromRoom(item);
//            gameController.getPlayer().addItemToBag(item);
//        }
//    }
//
//    public void noDoor() {
//        System.out.println("Coglione non c'è una porta su quel lato");
//    }
//
//    public void commandProcessing(String command) {
//
//        if (command.equalsIgnoreCase("go north")) {
//            if (gameController.changeRoom(Direction.NORTH) == null) {
//                noDoor();
//            } else {
//                look();
//            }
//
//        } else if (command.equalsIgnoreCase("go south")) {
//            if (gameController.changeRoom(Direction.SOUTH) == null) {
//                noDoor();
//            } else {
//                look();
//            }
//
//        } else if (command.equalsIgnoreCase("go east")) {
//            if (gameController.changeRoom(Direction.EAST) == null) {
//                noDoor();
//            } else {
//                look();
//            }
//
//        } else if (command.equalsIgnoreCase("go west")) {
//            if (gameController.changeRoom(Direction.WEST) == null) {
//                noDoor();
//            } else {
//                look();
//            }
//
//        } else if (command.equalsIgnoreCase("look")) {
//            look();
//        } else if (command.equalsIgnoreCase("bag")) {
//            commandTrue.execute();
//        } else if (command.startsWith("drop")) {
//            String itemToDrop = command.substring(5).trim();
//            for (Item itemInTheBag : gameController.getPlayer().getAllItemsInBag()) {
//                if (itemInTheBag.getName().equalsIgnoreCase(itemToDrop)) {
//                    dropItem(itemInTheBag);
//                    System.out.println("Hai droppato " + itemInTheBag.getName());
//                    break;
//                }
//            }
//
//        } else if (command.startsWith("get")) {
//            String itemToGet = command.substring(4).trim();
//            for (Item itemInTheRoom : roomController.getCurrentRoom().getRoomItemList()) {
//                if (itemInTheRoom.getName().equalsIgnoreCase(itemToGet)) {
//                    getItem(itemInTheRoom);
//                    System.out.println("Hai preso " + itemInTheRoom.getName());
//                    break;
//                }
//            }
//        } else if (command.equalsIgnoreCase("quit")) {
//            gameController.setQuit(true);
//        } else {
//            System.out.println("Nun ho capito, ripeti!");
//        }
//    }


}

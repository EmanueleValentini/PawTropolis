package it.alten;

import it.alten.game.controller.CommandController;
import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;


public class Main {
    public static void main(String[] args) {

        CommandController commandController = new CommandController();
        RoomController roomController = new RoomController();
        System.out.println(roomController.getCurrentRoom().roomDescription());
        commandController.commandProcessing("GO EaSt");


    }
}
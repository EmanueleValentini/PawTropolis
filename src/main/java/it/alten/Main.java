package it.alten;

import it.alten.game.controller.GameController;



public class Main {
    public static void main(String[] args) {

        GameController gameController = GameController.getInstance();
        gameController.runGame();


    }
}
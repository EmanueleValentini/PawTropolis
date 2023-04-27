package it.alten;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new RoomController());
        gameController.runGame();
    }
}

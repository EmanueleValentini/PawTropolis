package it.alten;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;
import it.alten.game.model.CommandFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        GameController gameController = GameController.getInstance();
        gameController.runGame();
    }
}

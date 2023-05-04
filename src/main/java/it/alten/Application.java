package it.alten;

import it.alten.game.controller.GameController;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        GameController.getInstance().runGame();
    }
    
}

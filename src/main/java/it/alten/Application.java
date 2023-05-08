package it.alten;

import it.alten.game.controller.GameController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {
       ApplicationContext context =  SpringApplication.run(Application.class, args);
       GameController gameController = context.getBean(GameController.class);
       gameController.runGame();


    }
    
}

package it.alten.game.service;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ConfigBean {
    @Bean
    public GameController gameController() {
        GameController gameController = new GameController();
        gameController.setRoomController(roomController());
        return gameController;
    }
    @Bean
    public RoomController roomController() {
        return new RoomController();
    }
}

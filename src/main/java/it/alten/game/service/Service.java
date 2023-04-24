package it.alten.game.service;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Service {
    @Bean
    public GameController gameController() {
        return new GameController();
    }

    @Bean
    public RoomController roomController() {
        return new RoomController();
    }
}

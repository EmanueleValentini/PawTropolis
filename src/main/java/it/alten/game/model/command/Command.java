package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
public abstract class Command {
    @Autowired
    private GameController gameController;
    public GameController getGameController() {
        return gameController;
    }

    public abstract void execute();

}

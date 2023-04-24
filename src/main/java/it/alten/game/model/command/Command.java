package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Getter
@Component
public abstract class Command {

    private RoomController roomController;
    private GameController gameController;

    @Autowired
    public Command(GameController gameController, RoomController roomController) {
        this.roomController = roomController;
        this.gameController = gameController;
    }

    public abstract void execute();

}

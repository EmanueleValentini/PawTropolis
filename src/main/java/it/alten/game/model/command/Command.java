package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.controller.RoomController;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Getter
@Component
public abstract class Command {

    private final RoomController roomController;
    private final GameController gameController;

    protected Command() {
        this.roomController = RoomController.getInstance();
        this.gameController = GameController.getInstance();
    }

    public abstract void execute();

}

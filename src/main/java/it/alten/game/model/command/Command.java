package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public abstract class Command {
    private GameController gameController;


    protected Command() {
        this.gameController = GameController.getInstance();
    }

    public abstract void execute();

}

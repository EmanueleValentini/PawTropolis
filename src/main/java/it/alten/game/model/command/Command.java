package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public abstract class Command {


    private GameController gameController;
    @Autowired
    protected Command(){

    }

    public GameController getGameController() {
        return gameController;
    }

    @Autowired
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract void execute();

}

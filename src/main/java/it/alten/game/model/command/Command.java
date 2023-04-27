package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public abstract class Command {
    private GameController gameController;

    @Autowired
    public Command() {
        this.gameController = GameController.getInstance();
    }

    public abstract void execute();

}

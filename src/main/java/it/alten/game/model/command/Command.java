package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
@Data
public abstract class Command {

    protected GameController gameController;

    @Autowired
    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract void execute();

}

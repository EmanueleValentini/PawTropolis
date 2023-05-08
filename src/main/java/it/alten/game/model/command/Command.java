package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
@Data
public abstract class Command {

    private GameController gameController;

    @Autowired
    protected Command(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract void execute();

}

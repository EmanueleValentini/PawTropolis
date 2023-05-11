package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Component
@NoArgsConstructor
@Data
public abstract class ParametrizedCommand extends Command {

    protected List<String> parameters;

    @Autowired
    protected ParametrizedCommand (GameController gameController) {
        super(gameController);
        this.parameters = new ArrayList<>();
    }

    protected ParametrizedCommand (GameController gameController, List<String> parameters) {
        super(gameController);
        this.parameters = parameters;
    }
}

package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Component
@NoArgsConstructor
@Data
public abstract class ParametrizedCommand extends Command {

    protected String parameter;

    @Autowired
    protected ParametrizedCommand (GameController gameController) {
        super(gameController);
        this.parameter = 
    }


}

package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.enums.Direction;
import it.alten.game.service.RoomService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component("go")
public class GoCommand extends ParametrizedCommand {

    RoomService roomService;

    @Autowired
    public GoCommand(GameController gameController) {
        super(gameController);
    }

    public GoCommand(GameController gameController, List<String> parameters) {
        super(gameController, parameters);
    }

    @Override
    public void execute() {
        Direction direction = Direction.of(String.join(" ", parameters));
        if (gameController.changeRoom()) {
            System.out.println("Stai in " + roomService.findByPlayer(true));
        } else {
            System.out.println("Nun ce poi annà");
        }
    }
}

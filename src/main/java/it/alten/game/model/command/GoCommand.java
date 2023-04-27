package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class GoCommand extends Command {

    private String input;

    private LookCommand lookCommand = new LookCommand();

    public GoCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute() {
        String direction = input.replace("go ", "");
        if (direction.equalsIgnoreCase("north")) {
            GameController.getInstance().changeRoom(Direction.NORTH);
            lookCommand.execute();
        } else if (direction.equalsIgnoreCase("south")) {
            GameController.getInstance().changeRoom(Direction.SOUTH);
            lookCommand.execute();
        } else if (direction.equalsIgnoreCase("east")) {
            GameController.getInstance().changeRoom(Direction.EAST);
            lookCommand.execute();
        } else if (direction.equalsIgnoreCase("west")) {
            GameController.getInstance().changeRoom(Direction.WEST);
            lookCommand.execute();
        } else {
            System.out.println("E do la vedi la porta???");
            lookCommand.execute();
        }
    }
}

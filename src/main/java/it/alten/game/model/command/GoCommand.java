package it.alten.game.model.command;

import it.alten.game.model.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
public class GoCommand extends Command {
    private final LookCommand lookCommand = new LookCommand();

    private String input;

    @Override
    public void execute() {
        String direction = input.replace("go ", "");
        if (direction.equalsIgnoreCase("north")) {
            getGameController().changeRoom(Direction.NORTH);
            lookCommand.execute();
        } else if (direction.equalsIgnoreCase("south")) {
            getGameController().changeRoom(Direction.SOUTH);
            lookCommand.execute();
        } else if (direction.equalsIgnoreCase("east")) {
            getGameController().changeRoom(Direction.EAST);
            lookCommand.execute();
        } else if (direction.equalsIgnoreCase("west")) {
            getGameController().changeRoom(Direction.WEST);
            lookCommand.execute();
        } else {
            System.out.println("E do la vedi la porta???");
            lookCommand.execute();
        }
    }
}

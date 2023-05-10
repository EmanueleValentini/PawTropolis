package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.Room;
import it.alten.game.model.enums.Direction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Component
public class GoCommand extends Command {

    private String input;

    private LookCommand lookCommand;

    public GoCommand(String input) {
        this.input = input;
    }

    @Autowired
    public GoCommand(GameController gameController, LookCommand lookCommand) {

        super(gameController);
        this.lookCommand = lookCommand;
    }

    public GoCommand(GameController gameController, String input) {
        super(gameController);
        this.input = input;
    }

    @Override
    public void execute() {
        Map<Direction, Room> adjacentRooms = gameController.getRoomController().getMap();
        String direction = input.replace("go ", "");
        if (direction.equalsIgnoreCase("north") &&
        adjacentRooms.containsKey(Direction.NORTH)) {
            getGameController().changeRoom(Direction.NORTH);
            lookCommand.execute();

        } else if (direction.equalsIgnoreCase("south") &&
                adjacentRooms.containsKey(Direction.SOUTH)) {
            getGameController().changeRoom(Direction.SOUTH);
            lookCommand.execute();

        } else if (direction.equalsIgnoreCase("east") &&
                adjacentRooms.containsKey(Direction.EAST)) {
            getGameController().changeRoom(Direction.EAST);
            lookCommand.execute();

        } else if (direction.equalsIgnoreCase("west") &&
                adjacentRooms.containsKey(Direction.WEST)) {
            getGameController().changeRoom(Direction.WEST);
            lookCommand.execute();

        } else {

            System.out.println("E do la vedi la porta???");
            lookCommand.execute();
        }
    }
}

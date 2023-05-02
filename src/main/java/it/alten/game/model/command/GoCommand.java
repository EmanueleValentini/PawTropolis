package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.Room;
import it.alten.game.model.enums.Direction;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

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

        Map<Direction, Room> adjacentRooms = GameController.getInstance().getRoomController().getCurrentRoom().getAdjacentRoomsList();
        String direction = input.replace("go ", "");
        if (direction.equalsIgnoreCase("north") &&
        adjacentRooms.containsKey(Direction.NORTH)) {
            GameController.getInstance().changeRoom(Direction.NORTH);
            lookCommand.execute();

        } else if (direction.equalsIgnoreCase("south") &&
                adjacentRooms.containsKey(Direction.SOUTH)) {
            GameController.getInstance().changeRoom(Direction.SOUTH);
            lookCommand.execute();

        } else if (direction.equalsIgnoreCase("east") &&
                adjacentRooms.containsKey(Direction.EAST)) {
            GameController.getInstance().changeRoom(Direction.EAST);
            lookCommand.execute();

        } else if (direction.equalsIgnoreCase("west") &&
                adjacentRooms.containsKey(Direction.WEST)) {
            GameController.getInstance().changeRoom(Direction.WEST);
            lookCommand.execute();

        } else {

            System.out.println("E do la vedi la porta???");
            lookCommand.execute();
        }
    }
}

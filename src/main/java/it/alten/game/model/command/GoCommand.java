package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.enums.Direction;
import lombok.Getter;
import lombok.Setter;

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
        if (direction.equalsIgnoreCase("north") &&
        GameController.getInstance().getRoomController().getCurrentRoom().getAdjacentRoomsList().containsKey(Direction.NORTH)) {
            GameController.getInstance().changeRoom(Direction.NORTH);
            lookCommand.execute();

        } else if (direction.equalsIgnoreCase("south") &&
                GameController.getInstance().getRoomController().getCurrentRoom().getAdjacentRoomsList().containsKey(Direction.SOUTH)) {
            GameController.getInstance().changeRoom(Direction.SOUTH);
            lookCommand.execute();

        } else if (direction.equalsIgnoreCase("east") &&
                GameController.getInstance().getRoomController().getCurrentRoom().getAdjacentRoomsList().containsKey(Direction.EAST)) {
            GameController.getInstance().changeRoom(Direction.EAST);
            lookCommand.execute();

        } else if (direction.equalsIgnoreCase("west") &&
                GameController.getInstance().getRoomController().getCurrentRoom().getAdjacentRoomsList().containsKey(Direction.WEST)) {
            GameController.getInstance().changeRoom(Direction.WEST);
            lookCommand.execute();

        } else {

            System.out.println("E do la vedi la porta???");
            lookCommand.execute();
        }
    }
}

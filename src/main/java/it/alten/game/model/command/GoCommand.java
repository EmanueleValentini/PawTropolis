package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.enums.Direction;

public class GoCommand extends ParametrizedCommand {

    private GameController gameController;
    private LookCommand lookCommand;
    @Override
    public void execute(String parameter) {
        String direction = parameter.replace("go","");
        if (direction.equalsIgnoreCase("north")){
            gameController.changeRoom(Direction.NORTH);
            lookCommand.execute(parameter);
        } else if (direction.equalsIgnoreCase("south")) {
            gameController.changeRoom(Direction.SOUTH);
            lookCommand.execute(parameter);
        } else if (direction.equalsIgnoreCase("east")) {
            gameController.changeRoom(Direction.EAST);
            lookCommand.execute(parameter);
        } else if (direction.equalsIgnoreCase("west")) {
            gameController.changeRoom(Direction.WEST);
            lookCommand.execute(parameter);
        }
    }
}

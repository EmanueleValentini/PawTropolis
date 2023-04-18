package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.enums.Direction;

public class GoCommand extends ParametrizedCommand {

    private GameController gameController;
    private LookCommand lookCommand;
    @Override
    public void execute(String parameter) {
        if (parameter.equalsIgnoreCase("north")){
            gameController.changeRoom(Direction.NORTH);
            lookCommand.execute();
        } else if (parameter.equalsIgnoreCase("south")) {
            gameController.changeRoom(Direction.SOUTH);
            lookCommand.execute();
        } else if (parameter.equalsIgnoreCase("east")) {
            gameController.changeRoom(Direction.EAST);
            lookCommand.execute();
        } else if (parameter.equalsIgnoreCase("west")) {
            gameController.changeRoom(Direction.WEST);
            lookCommand.execute();
        }
    }
}

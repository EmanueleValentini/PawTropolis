package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.enums.Direction;

import static it.alten.game.model.CommandFactory.getParameter;

public class GoCommand extends Command {

    private LookCommand lookCommand = new LookCommand();



    @Override
    public void execute() {
        String parameter = getParameter();
        String direction = parameter.replace("go ","");
        if (direction.equalsIgnoreCase("north")){
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

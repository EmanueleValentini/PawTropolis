package it.alten.game.model.command;

import it.alten.game.model.enums.Direction;

public class GoCommand extends Command {

    private final LookCommand lookCommand = new LookCommand();

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public GoCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute() {
        String direction = input.replace("go ","");
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

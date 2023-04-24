package it.alten.game.model.command;

import org.springframework.stereotype.Component;

@Component
public class LookCommand extends Command {

    @Override
    public void execute() {
        String description = getGameController().getRoomController().getCurrentRoom().roomDescription() + "\n";
        System.out.println(description);
    }
}

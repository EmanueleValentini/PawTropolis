package it.alten.game.model.command;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class BagCommand extends Command {

    @Override
    public void execute() {
        if (getGameController().getPlayer().getAllItemsInBag().isEmpty()) {
            System.out.println("Non hai un cazzo");
        } else {
            System.out.println(getGameController().getPlayer().getAllItemsInBag());
        }
    }
}

package it.alten.game.model.command;

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

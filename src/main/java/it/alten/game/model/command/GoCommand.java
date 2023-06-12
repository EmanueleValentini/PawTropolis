package it.alten.game.model.command;

import it.alten.game.controller.GameController;
import it.alten.game.model.Bag;
import it.alten.game.model.Door;
import it.alten.game.model.enums.Direction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
@Component("go")
public class GoCommand extends ParametrizedCommand {

    @Autowired
    public GoCommand(GameController gameController) {
        super(gameController);
    }

    public GoCommand(GameController gameController, List<String> parameters) {
        super(gameController, parameters);
    }

    @Override
    public void execute() {
        Direction direction = Direction.of(String.join(" ", parameters));
        Door door = gameController.getCurrentRoom().getDoors().get(direction);
        if (!door.isClosed()) {
            isRoomChanged(direction);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Te serve na roba pè aprì la porta, ce voi prova? DAJE/CORCAZZO: ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("daje")) {
                System.out.println("Dimme qual è l'oggetto che apre sta cazzo de porta: ");
                String itemInput = scanner.nextLine();
                Bag bag = gameController.getPlayer().getBag();
                if (itemInput.equals(door.getItemToOpen().getName()) && bag.getInventory().contains(door.getItemToOpen())) {
                    door.setClosed(false);
                    bag.getInventory().remove(door.getItemToOpen());
                    bag.setAvailableSlots(bag.getAvailableSlots() + door.getItemToOpen().getRequestedSlots());
                    System.out.println("Che bucio de culo era quello giusto!");
                    isRoomChanged(direction);
                } else {
                    System.out.println("C'hai provato ma nun era quello giusto!");
                }
            } else {
                System.out.println("E che cazzo me l'hai chiesto a fa?");
            }
        }
    }

    public void isRoomChanged(Direction direction) {
        boolean isRoomChanged = getGameController().getRoomController().changeRoom(direction);
        if (isRoomChanged) {
            System.out.println("Stai in: " + gameController.getCurrentRoom().getName());
            System.out.println(getGameController().getRoomController().roomDescription());
        } else {
            System.out.println("Do la vedi la porta?");
        }

    }
}

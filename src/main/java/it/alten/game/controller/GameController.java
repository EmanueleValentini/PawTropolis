package it.alten.game.controller;

import it.alten.game.model.CommandFactory;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.command.Command;
import it.alten.game.model.enums.Direction;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@Data
public class GameController {

    private RoomController roomController;

    private CommandFactory commandFactory;

    private static final int DEFAULT_STARTING_LIFE_POINTS = 42;

    private Player player;

    private boolean quit;

    @Autowired
    public GameController(RoomController roomController, CommandFactory commandFactory) {
        this.roomController = roomController;
        this.commandFactory = commandFactory;
        this.quit = false;
    }


    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public Player getPlayer() {
        return player;
    }

    public Room changeRoom(Direction direction) {
        return RoomController.changeRoom(direction);
    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto a Pawtropolis come ti chiami?");
        String playerName = scanner.nextLine();
        player = new Player (playerName,DEFAULT_STARTING_LIFE_POINTS);
        System.out.println("Ciao " + playerName +". Hai " + DEFAULT_STARTING_LIFE_POINTS + " Bestemmie rimaste");
        System.out.println(getRoomController().getCurrentRoom().roomDescription());
        while (!quit) {
            System.out.println("Che vuoi fare?");
            String input = scanner.nextLine();
            Command command = getCommandFactory().createCommandFromString(input);
            command.execute();
        }
    }
}

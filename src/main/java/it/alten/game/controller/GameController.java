package it.alten.game.controller;

import it.alten.animal.controller.EagleController;
import it.alten.animal.controller.LionController;
import it.alten.animal.controller.TigerController;
import it.alten.game.model.CommandFactory;
import it.alten.game.model.Player;
import it.alten.game.model.command.Command;
import it.alten.game.utils.mapper.PlayerMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@Data
public class GameController {

    private final RoomConnectionController roomConnectionController;

    private RoomController roomController;

    private CommandFactory commandFactory;

    private static final int DEFAULT_STARTING_LIFE_POINTS = 42;

    private final PlayerController playerController;

    private final ItemInBagController itemInBagController;

    private final ItemInRoomController itemInRoomController;

    private final BagController bagController;

    private Player player;

    private boolean quit;

    private final PlayerMapper playerMapper;

    private final LionController lionController;

    private final TigerController tigerController;

    private final EagleController eagleController;


    @Autowired
    public GameController(RoomConnectionController roomConnectionController, RoomController roomController, CommandFactory commandFactory, PlayerController playerController, ItemInBagController itemInBagController, ItemInRoomController itemInRoomController, BagController bagController, PlayerMapper playerMapper, LionController lionController, TigerController tigerController, EagleController eagleController) {
        this.roomConnectionController = roomConnectionController;
        this.roomController = roomController;
        this.commandFactory = commandFactory;
        this.playerController = playerController;
        this.itemInBagController = itemInBagController;
        this.itemInRoomController = itemInRoomController;
        this.bagController = bagController;
        this.playerMapper = playerMapper;
        this.lionController = lionController;
        this.tigerController = tigerController;
        this.eagleController = eagleController;
        this.quit = false;

    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public Player getPlayer() {
        return player;
    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto a Pawtropolis come ti chiami?");
        String playerName = scanner.nextLine();
        player = playerController.findById(1);
        player.setName(playerName);
        playerController.save(player);
        System.out.println("Ciao " + player.getName() + ". Hai " + player.getLifePoints() + " Bestemmie rimaste");
        System.out.println(roomController.roomDescription());
        while (!quit) {
            System.out.println("Che vuoi fare?");
            String input = scanner.nextLine();
            Command command = getCommandFactory().createCommandFromString(input);
            command.execute();
        }
    }
}

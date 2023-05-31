package it.alten.game.controller;

import it.alten.game.model.CommandFactory;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.command.Command;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.model.enums.Direction;
import it.alten.game.utils.mapper.BagMapper;
import it.alten.game.utils.mapper.PlayerMapper;
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

    private final PlayerController playerController;

    private final ItemInBagController itemInBagController;

    private final ItemInRoomController itemInRoomController;

    private final BagController bagController;

    private final PlayerMapper playerMapper;

    private final BagMapper bagMapper;

    private Player player;

    private boolean quit;

    private Room currentRoom;

    @Autowired
    public GameController(RoomController roomController, CommandFactory commandFactory, PlayerController playerController, ItemInBagController itemInBagController, ItemInRoomController itemInRoomController, BagController bagController, PlayerMapper playerMapper, BagMapper bagMapper) {
        this.roomController = roomController;
        this.commandFactory = commandFactory;
        this.playerController = playerController;
        this.itemInBagController = itemInBagController;
        this.itemInRoomController = itemInRoomController;
        this.bagController = bagController;
        this.playerMapper = playerMapper;
        this.bagMapper = bagMapper;
        this.quit = false;
    }

    //TODO: rifattorizza ora che si usa il db

    //TODO: NON SAPEVO DOVE METTERLO ma fai un controller per la descrizione che si richiama i service degli item e animali

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean changeRoom(Direction direction) {
        if (playerController.getPlayerService().updateCurrentRoomById(player.getId(), player)){
            return true;
        }
        return false;
    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto a Pawtropolis come ti chiami?");
        String playerName = scanner.nextLine();
        player = playerController.getPlayerService().findById(1);
        PlayerDto playerDto = playerMapper.toDTO(player);
        playerDto.setName(playerName);
        playerController.getPlayerService().save(playerDto);
        System.out.println("Ciao " + playerName +". Hai " + DEFAULT_STARTING_LIFE_POINTS + " Bestemmie rimaste");
        System.out.println(playerController.getCurrentRoom(player.getId()).roomDescription());
        while (!quit) {
            System.out.println("Che vuoi fare?");
            String input = scanner.nextLine();
            Command command = getCommandFactory().createCommandFromString(input);
            command.execute();
        }
    }
}

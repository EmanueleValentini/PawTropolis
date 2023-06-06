package it.alten.game.controller;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.service.PlayerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void save (Player player) {
        playerService.save(player);
    }

    public Player findById (int id) {
        return playerService.findById(id);
    }

    public void updatePlayerRoom (Room room) {
        playerService.updatePlayerRoom(room);
    }
}

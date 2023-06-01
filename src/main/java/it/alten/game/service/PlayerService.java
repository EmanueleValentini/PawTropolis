package it.alten.game.service;

import it.alten.game.model.Player;
import org.springframework.stereotype.Service;


@Service
public interface PlayerService {

    Player save (Player player);

    boolean updateCurrentRoomById (int id, Player player);

    Player findById(int id);
}

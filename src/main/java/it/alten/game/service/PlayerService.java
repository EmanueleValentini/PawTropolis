package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import org.springframework.stereotype.Service;



public interface PlayerService {

    Player save (Player player);

    boolean updateCurrentRoomById (int id, Player player);

    Player findById(int id);

    void updateRoom(int id, Room newRoom);

}

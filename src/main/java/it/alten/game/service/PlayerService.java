package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.Room;


public interface PlayerService {

    Player save (Player player);

    boolean updateCurrentRoomById (int id, Player player);

    Player findById(int id);

    void updatePlayerRoom(Room room);
}

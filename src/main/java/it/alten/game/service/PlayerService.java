package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.Room;


public interface PlayerService {

    Player save (Player player);

    Player findById(int id);

}

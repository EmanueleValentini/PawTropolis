package it.alten.animal.service;

import it.alten.animal.model.Eagle;
import it.alten.game.model.Room;

import java.util.List;

public interface EagleService {

    List<Eagle> findByRoom(Room room);

}

package it.alten.animal.service;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Tiger;
import it.alten.animal.model.dto.TigerDto;
import it.alten.game.model.Room;

import java.util.List;

public interface TigerService {

    List<Tiger> findByRoom(Room room);

    void save(TigerDto tigerDto);

}

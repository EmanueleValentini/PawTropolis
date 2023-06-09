package it.alten.animal.service;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Lion;
import it.alten.animal.model.dto.LionDto;
import it.alten.game.model.Room;

import java.util.List;

public interface LionService {

    List<Lion> findByRoom(Room room);

    void save(LionDto lionDto);

}

package it.alten.game.service;

import it.alten.game.model.Room;
import it.alten.game.model.dto.RoomDto;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {

    Room save (RoomDto roomDto);

    Room findByName (String name);

    Room findById (int id);

    boolean deleteById (int id);
}

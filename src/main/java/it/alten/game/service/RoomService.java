package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {

    Room save (Room room);

    Room findByName (String name);

    Room findById (int id);

    boolean deleteById (int id);

    List<Room> findAll();


    Room findByIsPlayerInTrue();

    void updateIsPlayerInById(int id, boolean isPlayerIn);

}

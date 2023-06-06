package it.alten.game.service;

import it.alten.game.model.Room;
import it.alten.game.model.RoomConnection;
import it.alten.game.model.enums.Direction;

import java.util.List;

public interface RoomConnectionService {

    List<RoomConnection> findAllByCurrentRoom(Room room);

    RoomConnection findByCurrentRoomAndDirection(Room room, Direction direction);

    RoomConnection findById(int id);
}

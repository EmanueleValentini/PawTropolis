package it.alten.game.service;

import it.alten.game.model.Room;
import it.alten.game.model.RoomConnection;
import it.alten.game.model.enums.Direction;
import it.alten.game.repository.RoomConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomConnectionServiceImpl implements RoomConnectionService{


    private final RoomConnectionRepository roomConnectionRepository;

    @Autowired
    public RoomConnectionServiceImpl(RoomConnectionRepository roomConnectionRepository) {
        this.roomConnectionRepository = roomConnectionRepository;
    }

    @Override
    public List<RoomConnection> findAllByCurrentRoom(Room room) {
        return roomConnectionRepository.findAllByCurrentRoom(room);
    }

    @Override
    public RoomConnection findByCurrentRoomAndDirection(Room room, Direction direction) {
        return roomConnectionRepository.findByCurrentRoomAndDirection(room, direction);
    }
}

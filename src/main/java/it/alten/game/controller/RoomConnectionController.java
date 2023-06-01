package it.alten.game.controller;

import it.alten.game.model.Room;
import it.alten.game.model.RoomConnection;
import it.alten.game.model.enums.Direction;
import it.alten.game.service.RoomConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RoomConnectionController {

    private final RoomConnectionService roomConnectionService;

    @Autowired
    public RoomConnectionController(RoomConnectionService roomConnectionService) {
        this.roomConnectionService = roomConnectionService;
    }

    public List<RoomConnection> findAllByCurrentRoom(Room room) {

        return roomConnectionService.findAllByCurrentRoom(room);
    }

    public RoomConnection findByCurrentRoomAndDirection(Room room, Direction direction) {


        return roomConnectionService.findByCurrentRoomAndDirection(room, direction);
    }

}

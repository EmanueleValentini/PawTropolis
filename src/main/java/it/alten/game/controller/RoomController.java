package it.alten.game.controller;

import it.alten.game.model.Room;
import it.alten.game.service.PlayerService;
import it.alten.game.service.RoomService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService, PlayerService playerService) {
        this.roomService = roomService;
    }

    private List<Room> retrieveMap() {
        return roomService.findAll();
    }


//TODO: caricare tutte le stanze del db, e gestirne lo spostamento


}

package it.alten.game.controller;

import it.alten.game.model.Room;
import it.alten.game.service.ItemInRoomService;
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

    private final ItemInRoomService itemInRoomService;


    @Autowired
    public RoomController(RoomService roomService, ItemInRoomService itemInRoomService) {
        this.roomService = roomService;
        this.itemInRoomService = itemInRoomService;
    }

    public List<Room> retrieveMap() {
        return roomService.findAll();
    }

    public Room findById(int id) {
        return roomService.findById(id);
    }

    public Room findByPlayer(boolean isIn) {
        return roomService.findByPlayer(isIn);
    }

    public String roomDescription() {

        Room room = roomService.findByPlayer(true);

        String message = "Sei nella stanza " + room.getName();
        if (!itemInRoomService.findAllByRoom(room).isEmpty()) {
            message += "\nCi sono questi oggetti: " + itemInRoomService.findAllByRoom(room);
        }
        return message;
    }
    }


//TODO: caricare tutte le stanze del db, e gestirne lo spostamento




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

    private final ItemInRoomController itemInRoomController;

    private final PlayerService playerService;




    @Autowired
    public RoomController(RoomService roomService, ItemInRoomController itemInRoomController, PlayerService playerService) {
        this.roomService = roomService;
        this.itemInRoomController = itemInRoomController;


        this.playerService = playerService;
    }

    public List<Room> retrieveMap() {
        return roomService.findAll();
    }

    public Room findById(int id) {
        return roomService.findById(id);
    }


    public String roomDescription(Room currentRoom) {

        String message = "Sei nella stanza " + playerService.findById(1).getRoom();
        if (!itemInRoomController.findByRoom(currentRoom).isEmpty()) {
            message += "\nCi sono questi oggetti: " + itemInRoomController.findByRoom(currentRoom).toString();
        }
        return message;
    }

    }


//TODO: caricare tutte le stanze del db, e gestirne lo spostamento




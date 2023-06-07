package it.alten.game.controller;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.service.PlayerService;
import it.alten.game.service.RoomConnectionService;
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

    private final RoomConnectionService roomConnectionService;




    @Autowired
    public RoomController(RoomService roomService, ItemInRoomController itemInRoomController, PlayerService playerService, RoomConnectionService roomConnectionService) {
        this.roomService = roomService;
        this.itemInRoomController = itemInRoomController;


        this.playerService = playerService;
        this.roomConnectionService = roomConnectionService;
    }

    public List<Room> retrieveMap() {
        return roomService.findAll();
    }

    public Room findById(int id) {
        return roomService.findById(id);
    }


    public String roomDescription() {

        Room room = findByIsPlayerInTrue();

        String message = "Sei nella stanza " + room.getName();
        if (!itemInRoomController.findByRoom(room).isEmpty()) {
            message += "\nCi sono questi oggetti: " + itemInRoomController.findByRoom(room).toString();
        }
        if (!roomConnectionService.findAllByCurrentRoom(room).isEmpty()) {
            message += "\nPuoi andare in sti posti: " + roomConnectionService.findAllByCurrentRoom(room);
        }
        return message;
    }


    public List<Room> findAll(){
        return roomService.findAll();
    }

    public Room findByIsPlayerInTrue() {
        return roomService.findByIsPlayerInTrue();
    }

    public void updateIsPlayerInById(int id, boolean isPlayerIn) {
        roomService.updateIsPlayerInById(id, isPlayerIn);
    }
}




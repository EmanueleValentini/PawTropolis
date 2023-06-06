package it.alten.game.controller;

import it.alten.game.model.Player;
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


    public String roomDescription() {

        Player player = playerService.findById(1);
        Room room = findRoomByPlayer(player);

        String message = "Sei nella stanza " + room.getName();
        if (!itemInRoomController.findByRoom(room).isEmpty()) {
            message += "\nCi sono questi oggetti: " + itemInRoomController.findByRoom(room).toString();
        }
        return message;
    }

    public Room findRoomByPlayer (Player player) {
        return roomService.findRoomByPlayer(player);
    }

    public List<Room> findAll(){
        return roomService.findAll();
    }
}




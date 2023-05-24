package it.alten.game.controller;

import it.alten.game.model.Room;
import it.alten.game.service.RoomService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class RoomController {

    private final RoomService roomService;

    private Room currentroom;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    private Room retrieveMap() {
        return roomService.findById(1);
    }
//TODO: caricare tutte le stanze del db, e gestirne lo spostamento

//    private static void connectRooms(Room room1, Room room2, Direction direction1, Direction direction2){
//        room1.connectRoom(room2, direction1);
//        room2.connectRoom(room1, direction2);
//    }
//
//    private static void connectRooms(Room room1, Room room2, Direction direction) {
//        room1.connectRoom(room2, direction);
//        room2.connectRoom(room1, getOppositeDirection(direction));
//    }
//
//    public boolean changeRoom(Direction direction) {
//        Room nextRoom = currentRoom.getAdjacentRoom(direction);
//        if (nextRoom != null) {
//            currentRoom = nextRoom;
//            return true;
//        }
//        return false;
//    }

}

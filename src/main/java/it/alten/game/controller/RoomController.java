package it.alten.game.controller;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Lion;
import it.alten.animal.model.Tiger;
import it.alten.game.model.Item;
import it.alten.game.model.Room;
import it.alten.game.model.enums.Direction;
import lombok.Data;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Map;

import static it.alten.game.model.enums.Direction.getOppositeDirection;

@Controller
@Data
public class RoomController {

    private Room currentRoom;


    public RoomController() {
         ;
    }



    private static void connectRooms(Room room1, Room room2, Direction direction1, Direction direction2){
        room1.connectRoom(room2, direction1);
        room2.connectRoom(room1, direction2);
    }

    private static void connectRooms(Room room1, Room room2, Direction direction) {
        room1.connectRoom(room2, direction);
        room2.connectRoom(room1, getOppositeDirection(direction));
    }

    public boolean changeRoom(Direction direction) {
        Room nextRoom = currentRoom.getAdjacentRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }

}

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
         this.currentRoom = createMap();
    }

    public Map<Direction, Room> getMap () {

        return currentRoom.getAdjacentRoomsList();
    }
    private Room createMap() {

        Room entrance = new Room("DAJE ROMA DAJE");
        Room bossRoom = new Room("La stanza del Boss");
        Room healingFountain = new Room("Viale Marconi");
        Room thiefCity = new Room("Napoli");
        Room terminiStation = new Room("Drug Ville");
        Room exit = new Room("Secco refresh");

        entrance.addItemToRoom(new Item("excalibur",
                "la famosa spada nella roccia che re Artù dovette estrarre per diventare re di Camelot, per poi sposare Ginevra e farsela rubare da Lancillotto",
                1));
        Lion lion1 = Lion.builder()
                        .name("Giancarlo")
                        .favouriteFood("Sushi")
                        .age(45)
                        .dateOfJoin(LocalDate.now())
                        .weight(1.7)
                        .height(2.5)
                        .tailLength(1.0)
                        .build();
        entrance.addAnimalToRoom(lion1);

        Eagle eagle1 = Eagle.builder()
                .name("L'acquila assassina")
                .favouriteFood("Umani")
                .age(10000)
                .dateOfJoin(LocalDate.now())
                .weight(3.4)
                .height(7.3)
                .wingspan(1.2)
                .build();
        bossRoom.addAnimalToRoom(eagle1);

        terminiStation.addItemToRoom(new Item("scudo", "scudo rotondo", 1));
        terminiStation.addItemToRoom(new Item("siringa", "ti cura di 50hp e ti fa...forse non ti cura", 1));
        Tiger tiger1 = Tiger.builder()
                .name("Amal")
                .favouriteFood("indiano")
                .age(24)
                .dateOfJoin(LocalDate.now())
                .weight(70.5)
                .height(1.70)
                .tailLength(2.1)
                .build();
        terminiStation.addAnimalToRoom(tiger1);

        Lion lion2 = Lion.builder()
                .name("Amal")
                .favouriteFood("indiano")
                .age(24)
                .dateOfJoin(LocalDate.now())
                .weight(70.5)
                .height(1.70)
                .tailLength(2.1)
                .build();
        thiefCity.addAnimalToRoom(lion2);
        thiefCity.addItemToRoom(new Item("orologio", "Oggetto rarissimo, conservalo bene nel taschino dietro dello zaino che non hai", 1));
        thiefCity.addItemToRoom(new Item("elmo", "ti protegge dagli headshot", 1));

        Lion lion3 = Lion.builder()
                .name("Calogero")
                .favouriteFood("Tè al limone")
                .age(100)
                .dateOfJoin(LocalDate.now())
                .weight(4.5)
                .height(1.0)
                .tailLength(6.7)
                .build();
        healingFountain.addAnimalToRoom(lion3);
        healingFountain.addItemToRoom(new Item("Soldi", "i soldi quelli veri", 1));

        Lion lion4 = Lion.builder()
                .name("Salvatore")
                .favouriteFood("Er sambucone molinari")
                .age(67)
                .dateOfJoin(LocalDate.now())
                .weight(8.5)
                .height(9.0)
                .tailLength(7.9)
                .build();
        exit.addAnimalToRoom(lion4);

        connectRooms(entrance, terminiStation, Direction.EAST);
        connectRooms(entrance, thiefCity, Direction.SOUTH);
        connectRooms(terminiStation, bossRoom, Direction.EAST, Direction.WEST);
        connectRooms(thiefCity, healingFountain, Direction.WEST, Direction.EAST);
        connectRooms(bossRoom, exit, Direction.NORTH, Direction.SOUTH);
        return entrance;
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

package it.alten.game.controller;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Lion;
import it.alten.animal.model.Tiger;
import it.alten.game.model.Door;
import it.alten.game.model.Item;
import it.alten.game.model.Room;
import it.alten.game.model.enums.Direction;
import lombok.Data;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static it.alten.game.model.enums.Direction.getOppositeDirection;

@Controller
@Data
public class RoomController {

    private Room currentRoom;


    public RoomController() {
         this.currentRoom = createMap();
    }

    private Room createMap() {

        Room entrance = new Room("DAJE ROMA DAJE");
        Room bossRoom = new Room("La stanza del Boss");
        Room healingFountain = new Room("Viale Marconi");
        Room thiefCity = new Room("Napoli");
        Room terminiStation = new Room("Drug Ville");
        Room exit = new Room("Secco refresh");


        Item excalibur = new Item("excalibur",
                "la famosa spada nella roccia che re Artù dovette estrarre per diventare re di Camelot, per poi sposare Ginevra e farsela rubare da Lancillotto",
                1);
        entrance.addItemToRoom(excalibur);

        Door formEntranceToTermini = new Door(excalibur);
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

        Door fromEntranceToThiefCity = new Door();
        Door fromTerminiToBoss = new Door();
        Door fromThiefToHealingFountain = new Door();
        Door fromBossToExit = new Door();

        connectRooms(entrance, terminiStation, Direction.EAST, formEntranceToTermini);
        connectRooms(entrance, thiefCity, Direction.SOUTH, fromEntranceToThiefCity);
        connectRooms(terminiStation, bossRoom, Direction.EAST, Direction.WEST, fromTerminiToBoss);
        connectRooms(thiefCity, healingFountain, Direction.WEST, Direction.EAST, fromThiefToHealingFountain);
        connectRooms(bossRoom, exit, Direction.NORTH, Direction.SOUTH, fromBossToExit);
        return entrance;
    }

    private static void connectRooms(Room room1, Room room2, Direction direction1, Direction direction2, Door door){
        room1.connectRoom(room2, direction1, door);
        room2.connectRoom(room1, direction2, door);
    }

    private static void connectRooms(Room room1, Room room2, Direction direction, Door door) {
        room1.connectRoom(room2, direction, door);
        room2.connectRoom(room1, getOppositeDirection(direction), door);
    }

    public boolean changeRoom(Direction direction) {
        Room nextRoom = currentRoom.getAdjacentRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }
        return false;
    }

    public StringBuilder roomDescription() {

        StringBuilder message = new StringBuilder("Sei nella stanza " + currentRoom.getName());
        if(!currentRoom.getRoomItemList().isEmpty()){
            message.append("\nCi sono questi oggetti: ").append(currentRoom.getRoomItemList());
        }
        if (!currentRoom.getAnimalList().isEmpty()){
            message.append("\nCi sono questi npc: ").append(currentRoom.getAnimalList());
        }
        message.append("\nPuoi andare: ").append(getDoorAndRoomMessage());
        return message;
    }

    public String getDoorAndRoomMessage() {
        Map<Direction, Room> directions = currentRoom.getAdjacentRoomsList();
        List<Direction> directionList = directions.keySet().stream().toList();
        List<Room> roomList = directions.values().stream().toList();
        if (directions.isEmpty()) {
            return "Empty";
        }
        StringBuilder doorsDescription = new StringBuilder("[");

        for (int i = 0; i < directionList.size(); i++) {
            Direction direction = directionList.get(i);
            doorsDescription.append(direction.getName());
            Room adjacentRoom = roomList.get(i);
            doorsDescription.append(" ");
            doorsDescription.append(adjacentRoom.getName());
            Door door = currentRoom.getDoors().get(direction);
            doorsDescription.append(getDoorState(door));

            if (i < directionList.size() - 1) {
                doorsDescription.append(", ");
            }
        }
        doorsDescription.append("]");

        return doorsDescription.toString();
    }

    public String getDoorState(Door door) {
        if (door.isClosed()) {
            return " (È chiusa cojone)";
        } else {
            return " (Tiratece contro che se apre)";
        }
    }

}

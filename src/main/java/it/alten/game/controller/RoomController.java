package it.alten.game.controller;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Lion;
import it.alten.animal.model.Tiger;
import it.alten.game.model.Item;
import it.alten.game.model.Room;
import it.alten.game.model.enums.Direction;

import java.time.LocalDate;

import static it.alten.game.model.enums.Direction.getOppositeDirection;

public class RoomController {

    private static Room currentRoom;

    private static RoomController instance;

    private RoomController() {
        currentRoom = createMap();
    }

    public static RoomController getInstance() {
        if (instance == null) {
            instance = new RoomController();
        }
        return instance;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    private static Room createMap() {

        Room entrance = new Room("DAJE ROMA DAJE");
        Room bossRoom = new Room("La stanza del Boss");
        Room healingFountain = new Room("Viale Marconi");
        Room thiefCity = new Room("Napoli");
        Room terminiStation = new Room("Drug Ville");
        Room exit = new Room("Secco refresh");
        entrance.addItemToRoom(new Item("excalibur",
                "la famosa spada nella roccia che re Artù dovette estrarre per diventare re di Camelot, per poi sposare Ginevra e farsela rubare da Lancillotto",
                1));
        entrance.addAnimalToRoom(new Lion("Giancarlo", "SUSHI", 45, LocalDate.now(), 1.7, 2.5, 4.5));

        bossRoom.addAnimalToRoom(new Eagle("L'aquila assassina", "Umani", 1000000, LocalDate.now(), 400.5, 300.3, 34.5));

        terminiStation.addItemToRoom(new Item("scudo", "scudo rotondo", 3));
        terminiStation.addItemToRoom(new Item("siringa", "ti cura di 50hp e ti fa...forse non ti cura", 2));
        terminiStation.addAnimalToRoom(new Tiger("Amal", "indiano", 24, LocalDate.now(), 70.5, 1.70, 23.0));

        thiefCity.addAnimalToRoom(new Lion("Amal", "indiano", 24, LocalDate.now(), 70.5, 1.70, 23.0));
        thiefCity.addItemToRoom(new Item("orologio", "Oggetto rarissimo, conservalo bene nel taschino dietro dello zaino che non hai", 2));
        thiefCity.addItemToRoom(new Item("elmo", "ti protegge dagli headshot", 1));

        healingFountain.addAnimalToRoom(new Lion("Calogero", "Tè al limone", 100, LocalDate.now(), 4.5, 1.0, 6.7));
        healingFountain.addItemToRoom(new Item("Soldi", "i soldi quelli veri", 1));

        exit.addAnimalToRoom(new Lion("Salvatore", "Er Sambucone Molinari", 67, LocalDate.now(), 8.5, 9.0, 7.9));

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

    public static Room changeRoom(Direction direction) {
        Room nextRoom = currentRoom.getAdjacentRoom(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return currentRoom;
        }
        return null;
    }

}

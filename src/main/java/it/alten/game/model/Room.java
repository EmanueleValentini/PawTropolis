package it.alten.game.model;

import it.alten.animal.model.Animal;
import it.alten.game.model.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String name;

    private List<Item> roomItemList;
    private List<Animal> animalList;

    private Map<Direction, Room> adjacentRoomsList;

    private Map<Direction,Door> doors;
    private int id;

    public Room(String name){

        this.name = name;
        this.roomItemList = new ArrayList<>();
        this.animalList = new ArrayList<>();
        this.adjacentRoomsList = new EnumMap<>(Direction.class);
        this.doors = new EnumMap<>(Direction.class);

    }
    public void connectRoom(Room room, Direction direction, Door door) {

        adjacentRoomsList.put(direction, room);
        doors.put(direction,door);
    }

    public Room unconnectRoom(Room room) {

        return adjacentRoomsList.values().remove(room)?room:null;
    }

    public Room unconnectRoom(Direction direction) {

        return adjacentRoomsList.remove(direction);
    }

    public Room getAdjacentRoom(Direction direction) {
        return adjacentRoomsList.get(direction);
    }

    public Door getAdjacentDoorByDirection(Direction direction) {
        return doors.get(direction);
    }

    public void removeItemFromRoom(Item item) {
        roomItemList.remove(item);
    }

    public void addAnimalToRoom(Animal animal) {

        animalList.add(animal);
    }

    public void addItemToRoom(Item item) {
        roomItemList.add(item);
    }


        @Override
    public String toString() {
        return name;
    }


}

package it.alten.game.model;

import it.alten.animal.model.Animal;
import it.alten.game.model.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Room {
    private String name;

    private List<Item> roomItemList;

    private List<Animal> animalList;

    private Map<Direction, Room> adjacentRoomsList;

    public Room(String name){

        this.name = name;
        this.roomItemList = new ArrayList<>();
        this.animalList = new ArrayList<>();
        this.adjacentRoomsList = new EnumMap<>(Direction.class);

    }
    public void connectRoom(Room room, Direction direction) {

        adjacentRoomsList.put(direction, room);
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

    public void removeItemFromRoom(Item item) {
        roomItemList.remove(item);
    }

    public void addAnimalToRoom(Animal animal) {

        animalList.add(animal);
    }

    public void addItemToRoom(Item item) {
        roomItemList.add(item);
    }

    public String roomDescription() {
        String message = "Sei nella stanza " + getName();
        if(!getRoomItemList().isEmpty()){
            message += "\nCi sono questi oggetti: " + getRoomItemList();
        }
        if (!getAnimalList().isEmpty()){
            message += "\nCi sono questi npc: " + getAnimalList();
        }
        if (!getAdjacentRoomsList().isEmpty()){
            message += "\nPuoi spostarti verso: " + getAdjacentRoomsList();
        }
        return message;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name) && Objects.equals(roomItemList, room.roomItemList) && Objects.equals(animalList, room.animalList) && Objects.equals(adjacentRoomsList, room.adjacentRoomsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roomItemList, animalList, adjacentRoomsList);
    }

    @Override
    public String toString() {
        return name;
    }
}

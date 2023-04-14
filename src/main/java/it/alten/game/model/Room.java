package it.alten.game.model;

import it.alten.animal.model.Animal;
import it.alten.game.model.enums.Direction;

import java.util.*;

public class Room {
    private String name;

    private List<Item> roomItemList;

    private List<Animal> animalList;

    private EnumMap<Direction, Room> adjacentRoomsList;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getRoomItemList() {
        return roomItemList;
    }

    public void setRoomItemList(List<Item> roomItemList) {
        this.roomItemList = roomItemList;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public EnumMap<Direction, Room> getAdjacentRoomsList() {
        return adjacentRoomsList;
    }

    public Room getAdjacentRoom(Direction direction) {
        return adjacentRoomsList.get(direction);
    }

    public void setAdjacentRoomsList(EnumMap<Direction, Room> adjacentRoomsList) {
        this.adjacentRoomsList = adjacentRoomsList;
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
    public String toString() {
        return name;
    }
}

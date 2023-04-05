package it.alten.game.model;

import it.alten.animal.model.Animal;
import it.alten.game.model.enums.AdjacentRooms;

import java.util.*;

public class Room {
    private String name;

    private List<Item> roomItemList;

    Map<Integer, Animal> animalMap;

    EnumMap<AdjacentRooms, Room> adjacentRoomsList;

    public Room(String name){

        this.name = name;
        this.roomItemList = new ArrayList<>();
        this.animalMap = new HashMap<>();
        this.adjacentRoomsList = new EnumMap<>(AdjacentRooms.class);

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

    public Map<Integer, Animal> getAnimalMap() {
        return animalMap;
    }

    public void setAnimalMap(Map<Integer, Animal> animalMap) {
        this.animalMap = animalMap;
    }

    public List<Room> getAdjacentRoomsList() {
        return adjacentRoomsList;
    }

    public void setAdjacentRoomsList(List<Room> adjacentRoomsList) {
        this.adjacentRoomsList = adjacentRoomsList;
    }

    public Item removeItemFromRoom(Item item) {
        roomItemList.remove(item);
        return item;
    }

    public Item addItemToRoom(Item item) {
        roomItemList.add(item);
        return item;
    }

    public void roomDescription() {
        System.out.println("Faggiano sei nella stanza " + this.name + "\n e ce sta: "
            + getRoomItemList().toString() + "\n in più ci sono sti tipi che te vojono mena': " + getAnimalMap().values()
                + "\n se ti vuoi levare dalle palle puoi andare (oltre che a fanculo): " +getAdjacentRoomsList().toString());
    }

    @Override
    public String toString() {
        return "Room" +
                "name='" + name + '\'' +
                ", roomItemList=" + roomItemList +
                ", animalMap=" + animalMap +
                ", adjacentRoomsList=" + adjacentRoomsList;
    }
}

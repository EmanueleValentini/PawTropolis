package it.alten.game.model;

import it.alten.animal.model.Animal;

import java.util.List;
import java.util.Map;

public class Room {
    private String name;

    private List<Item> roomItemList;

    Map<Integer, Animal> animalMap;

    List<Room> adjacentRoomsList;

    public Room(String name, List<Item> itemList, Map<Integer, Animal> animalMap, List<Room> adjacentRoomsList) {
        this.name = name;
        this.roomItemList = itemList;
        this.animalMap = animalMap;
        this.adjacentRoomsList = adjacentRoomsList;
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


}

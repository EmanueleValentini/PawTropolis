package it.alten.game.model;

import it.alten.animal.model.Animal;
import it.alten.game.model.enums.Direction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Room {
    private String name;

    @OneToMany(mappedBy = "room")
    private List<ItemInRoom> roomItemList;

    //TODO: lista di liste o almeno ci proviamo
    @OneToMany
    private List<Animal> animalList;


    //TODO: vedi n'po'che devi fa, è molto tricky dice Crostian
    @OneToMany
    private Map<Direction, Room> adjacentRoomsList;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public Room(String name){

        this.name = name;
        this.roomItemList = new ArrayList<>();
        this.animalList = new ArrayList<>();
        this.adjacentRoomsList = new EnumMap<>(Direction.class);

    }
//    public void connectRoom(Room room, Direction direction) {
//
//        adjacentRoomsList.put(direction, room);
//    }
//
//    public Room unconnectRoom(Room room) {
//
//        return adjacentRoomsList.values().remove(room)?room:null;
//    }
//
//    public Room unconnectRoom(Direction direction) {
//
//        return adjacentRoomsList.remove(direction);
//    }
//
//    public Room getAdjacentRoom(Direction direction) {
//        return adjacentRoomsList.get(direction);
//    }
//
//    public void removeItemFromRoom(ItemInRoom item) {
//        roomItemList.remove(item);
//    }
//
//    public void addAnimalToRoom(Animal animal) {
//
//        animalList.add(animal);
//    }
//
//    public void addItemToRoom(ItemInRoom item) {
//        roomItemList.add(item);
//    }
//
//    public String roomDescription() {
//        String message = "Sei nella stanza " + getName();
//        if(!getRoomItemList().isEmpty()){
//            message += "\nCi sono questi oggetti: " + getRoomItemList();
//        }
//        if (!getAnimalList().isEmpty()){
//            message += "\nCi sono questi npc: " + getAnimalList();
//        }
//        if (!getAdjacentRoomsList().isEmpty()){
//            message += "\nPuoi spostarti verso: " + getAdjacentRoomsList();
//        }
//        return message;
//    }


    @Override
    public String toString() {
        return name;
    }


}

package it.alten.game.model;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Lion;
import it.alten.animal.model.Tiger;
import it.alten.game.model.enums.Direction;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Room {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "room")
    private List<ItemInRoom> roomItemList;

    @OneToMany(mappedBy = "room")
    private List<Eagle> eagleList;

    @OneToMany(mappedBy = "room")
    private List<Tiger> tigerList;

    @OneToMany(mappedBy = "room")
    private List<Lion> lionList;


    //TODO: vedi n'po'che devi fa, è molto tricky dice Crostian
    @OneToMany
    @PrimaryKeyJoinColumn
    private Map<Direction, Room> connection;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public Room(String name){

        this.name = name;
        this.roomItemList = new ArrayList<>();
        this.lionList = new ArrayList<>();
        this.eagleList = new ArrayList<>();
        this.tigerList = new ArrayList<>();
        this.connection = new EnumMap<>(Direction.class);

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
    public String roomDescription() {
        String message = "Sei nella stanza " + getName();
        if(!getRoomItemList().isEmpty()){
            message += "\nCi sono questi oggetti: " + getRoomItemList();
        }
        if (!getLionList().isEmpty() || !getTigerList().isEmpty() || !getEagleList().isEmpty()) {
            if (!getLionList().isEmpty()) {
                message += "\nCi sono questi leoni: " + getLionList();
            }
            if (!getTigerList().isEmpty()) {
                message += "\nCi sono queste tigri: " + getTigerList();
            }
            if (!getEagleList().isEmpty()) {
                message += "\nCi sono queste aquile: " + getEagleList();
            }
        }
        if (!getConnection().isEmpty()){
            message += "\nPuoi spostarti verso: " + getConnection();
        }
        return message;
    }


    @Override
    public String toString() {
        return name;
    }


}

package it.alten.game.model;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Lion;
import it.alten.animal.model.Tiger;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "room_connection", joinColumns = @JoinColumn(name = "id_room1"), inverseJoinColumns = @JoinColumn(name = "id_room2"))
    private List<Room> adjacentRooms;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;



    public Room(String name) {

        this.name = name;
        this.roomItemList = new ArrayList<>();
        this.lionList = new ArrayList<>();
        this.eagleList = new ArrayList<>();
        this.tigerList = new ArrayList<>();
    }


    @Override
    public String toString() {
        return name;
    }

}

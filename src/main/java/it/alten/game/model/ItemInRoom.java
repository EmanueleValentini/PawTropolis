package it.alten.game.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "item_in_room")
public class ItemInRoom extends Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;


    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "requestedslots")
    private int requestedSlots;

    @Override
    public String toString() {
     return name;
    }

    public ItemInRoom(String name, String description, int requestedSlots, Room room) {
        super(name, description, requestedSlots);
        this.room = room;
    }
}

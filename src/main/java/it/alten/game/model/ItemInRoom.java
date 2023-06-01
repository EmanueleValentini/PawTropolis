package it.alten.game.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemInRoom that = (ItemInRoom) o;
        return requestedSlots == that.requestedSlots && Objects.equals(room, that.room) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), room, name, description, requestedSlots);
    }
}

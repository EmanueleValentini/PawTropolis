package it.alten.game.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Bag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @OneToMany (mappedBy = "bag")
    private List<ItemInBag> inventory;
    @Column(name = "slots")
    private int slots;
    @OneToOne (mappedBy = "bag")
    private Player player;


    private static final int MAX_SLOTS = 5;

    @Override
    public String toString() {
        return "Bag{" +
                "id=" + id +
                ", inventory=" + inventory +
                ", availableSlots=" + slots +
                '}';
    }

}

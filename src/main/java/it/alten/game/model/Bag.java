package it.alten.game.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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
    @Column(name = "availableslots")
    private int availableSlots;

    private static final int MAX_SLOTS = 5;
    @Column(name = "maxslots")
    private final int maxSlots;


    public Bag() {
        this.maxSlots = MAX_SLOTS;
        this.availableSlots = maxSlots;
        this.inventory = new ArrayList<>(MAX_SLOTS);
    }

    @Override
    public String toString() {
        return "Bag{" +
                "id=" + id +
                ", inventory=" + inventory +
                ", availableSlots=" + availableSlots +
                ", maxSlots=" + maxSlots +
                '}';
    }
}

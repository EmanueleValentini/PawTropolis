package it.alten.game.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Bag implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @OneToMany
    private List<Item> inventory;
    private int availableSlots;
    private static final int MAX_SLOTS = 5;
    private final int maxSlots;


    public Bag() {
        this.maxSlots = MAX_SLOTS;
        this.availableSlots = maxSlots;
        this.inventory = new ArrayList<>(MAX_SLOTS);
    }


    public void addItem(Item item) {
        if (availableSlots >= item.getRequestedSlots()) {
            inventory.add(item);
            availableSlots -= item.getRequestedSlots();
        }
    }

    public void removeItem(Item item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            availableSlots += item.getRequestedSlots();
        }

    }

    public boolean isSlotsAvailable() {
        return availableSlots > 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return availableSlots == bag.availableSlots && maxSlots == bag.maxSlots && Objects.equals(inventory, bag.inventory);
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

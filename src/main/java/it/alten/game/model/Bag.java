package it.alten.game.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Bag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @OneToMany
    private List<ItemInBag> inventory;
    private int availableSlots;
    private static final int MAX_SLOTS = 5;
    private final int maxSlots;


    public Bag() {
        this.maxSlots = MAX_SLOTS;
        this.availableSlots = maxSlots;
        this.inventory = new ArrayList<>(MAX_SLOTS);
    }


//    public void addItem(ItemInBag item) {
//        if (availableSlots >= item.getRequestedSlots()) {
//            inventory.add(item);
//            availableSlots -= item.getRequestedSlots();
//        }
//    }
//
//    public void removeItem(ItemInBag item) {
//        if (inventory.contains(item)) {
//            inventory.remove(item);
//            availableSlots += item.getRequestedSlots();
//        }
//
//    }
//
//    public boolean isSlotsAvailable() {
//        return availableSlots > 0;
//    }

}

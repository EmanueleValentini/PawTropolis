package it.alten.game.model;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private List<Item> inventory;
    private int availableSlots;
    private static final int DEFAULT_MAX_SLOTS = 10;
    private final int maxSlots;

    public Bag() {
        this.maxSlots = DEFAULT_MAX_SLOTS;
        this.availableSlots = maxSlots;
        this.inventory = new ArrayList<>(maxSlots);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public Item addItem(Item item) {
        if (!isFull()) {
            inventory.add(item);
            return item;
        } else {
            System.out.println("Hai la borsa piena coglione");
            return null;
        }

    }

    public Item removeItem(Item item) {
        if (!inventory.contains(item)) {
            System.out.println("Bro ma sei cieco, non ce l'hai sto coso");
            return null;
        } else {
            inventory.remove(item);
            return item;
        }

    }

    public boolean isFull() {
        return inventory.size() == maxSlots;
    }

    @Override
    public String toString() {
        return "Bag" +
                "inventory=" + inventory +
                ", availableSlots=" + availableSlots +
                ", maxSlots=" + maxSlots;
    }
}

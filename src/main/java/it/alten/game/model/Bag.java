package it.alten.game.model;

import java.util.List;

public class Bag {
    private List<Item> inventory;

    private int [] slots;

    public Bag(List<Item> inventory) {
        this.inventory = inventory;
        this.slots = new int[10];
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int[] getSlots() {
        return slots;
    }

    public void setSlots(int [] slots) {
        this.slots = slots;
    }
}

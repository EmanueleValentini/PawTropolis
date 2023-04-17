package it.alten.game.model;

import java.util.Objects;

public class Item {
    private String name;
    private String description;
    private int requestedSlots;

    public Item(String name, String description, int requestedSlots) {
        this.name = name;
        this.description = description;
        this.requestedSlots = requestedSlots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequestedSlots() {
        return requestedSlots;
    }

    public void setRequestedSlots(int requestedSlots) {
        this.requestedSlots = requestedSlots;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return requestedSlots == item.requestedSlots && Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, requestedSlots);
    }

    @Override
    public String toString() {
        return name;
    }
}

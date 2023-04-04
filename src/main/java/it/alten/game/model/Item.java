package it.alten.game.model;

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
    public String toString() {
        return name;
    }
}

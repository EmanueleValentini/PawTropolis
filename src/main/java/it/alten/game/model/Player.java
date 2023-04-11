package it.alten.game.model;

import java.util.List;

public class Player {
    private String name;
    private int lifePoints;
    private final Bag bag;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return lifePoints;
    }

    public void setPoints(int points) {
        this.lifePoints = points;
    }

    public void addItemToBag(Item item) {
        bag.addItem(item);
    }

    public void removeItemFromBag(Item item) {
        bag.removeItem(item);
    }

    public List<Item> getAllItemsInBag() {
        return bag.getInventory();
    }

    public Bag getBag() {
        return bag;
    }
}

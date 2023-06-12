package it.alten.game.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
public class Player {

    private int id;
    private String name;
    private int lifePoints;
    private final Bag bag;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag();
    }


    public boolean addItemToBag(Item item) {
        assert bag != null;
        if (bag.getAvailableSlots() >= item.getRequestedSlots()) {

            bag.addItem(item);
            return true;
        }
        return false;

    }

    public void removeItemFromBag(Item item) {
        assert bag != null;
        bag.removeItem(item);
    }

    public List<Item> getAllItemsInBag() {
        assert bag != null;
        return bag.getInventory();
    }




}

package it.alten.game.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor(force = true)
public class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private int lifePoints;
    @OneToOne
    private final Bag bag;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag();
    }


    public boolean addItemToBag(ItemInBag item) {
        assert bag != null;
        if (bag.getAvailableSlots() >= item.getRequestedSlots()) {

            bag.addItem(item);
            return true;
        }
        return false;

    }

    public void removeItemFromBag(ItemInBag item) {
        assert bag != null;
        bag.removeItem(item);
    }

    public List<ItemInBag> getAllItemsInBag() {
        assert bag != null;
        return bag.getInventory();
    }




}

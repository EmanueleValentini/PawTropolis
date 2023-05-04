package it.alten.game.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.Objects;

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


    public boolean addItemToBag(Item item) {
        if (bag.getAvailableSlots() >= item.getRequestedSlots()) {

            bag.addItem(item);
            return true;
        }
        return false;

    }

    public void removeItemFromBag(Item item) {
        bag.removeItem(item);
    }

    public List<Item> getAllItemsInBag() {
        return bag.getInventory();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return lifePoints == player.lifePoints && Objects.equals(name, player.name) && Objects.equals(bag, player.bag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lifePoints, bag);
    }
}

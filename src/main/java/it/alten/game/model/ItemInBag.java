package it.alten.game.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "item_in_bag")
public class ItemInBag extends Item{

    @ManyToOne
    @JoinColumn(name = "id_bag")
    private Bag bag;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "requestedslots")
    private int requestedSlots;
    public ItemInBag(String name, String description, int requestedSlots, Bag bag) {
        super(name, description, requestedSlots);
        this.bag = bag;

    }

    @Override
    public String toString() {
        return name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemInBag itemInBag = (ItemInBag) o;
        return requestedSlots == itemInBag.requestedSlots && Objects.equals(bag, itemInBag.bag) && Objects.equals(name, itemInBag.name) && Objects.equals(description, itemInBag.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bag, name, description, requestedSlots);
    }
}

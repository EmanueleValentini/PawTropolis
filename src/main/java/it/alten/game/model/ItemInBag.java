package it.alten.game.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class ItemInBag extends Item{

    @ManyToOne
    @JoinColumn(name = "id_bag")
    private Bag bag;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public ItemInBag(String name, String description, int requestedSlots, Bag bag) {
        super(name, description, requestedSlots);
        this.bag = bag;
    }
}

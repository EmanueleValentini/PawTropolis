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
@EqualsAndHashCode(callSuper = false)
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
}

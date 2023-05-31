package it.alten.game.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Bag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @OneToMany (mappedBy = "bag")
    private List<ItemInBag> inventory;
    @Column(name = "availableslots")
    private int availableSlots;

    @OneToOne(mappedBy = "bag")
    private Player player;

    private static final int MAX_SLOTS = 5;
    @Column(name = "maxslots")
    private int maxSlots;


    public Bag(Player player) {
        this.maxSlots = MAX_SLOTS;
        this.availableSlots = maxSlots;
        this.inventory = new ArrayList<>(MAX_SLOTS);
        this.player = player;
    }
}

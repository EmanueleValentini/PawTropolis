package it.alten.game.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ItemInBag extends Item{

    @ManyToOne
    @JoinColumn(name = "id_bag")
    private Bag bag;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}

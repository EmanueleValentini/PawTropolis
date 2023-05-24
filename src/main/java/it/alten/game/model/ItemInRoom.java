package it.alten.game.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ItemInRoom extends Item{

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



}

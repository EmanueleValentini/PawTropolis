package it.alten.game.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(force = true)
@EqualsAndHashCode
@Table(name = "player")
public class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "lifepoints",nullable = false)
    private int lifePoints;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id_bag")
    private final Bag bag;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id_room")
    private Room room;

    public Player(String name, int lifePoints, Bag bag, Room room) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = bag;
        this.room = room;
    }
}

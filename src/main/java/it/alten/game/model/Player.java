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
public class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lifePoints")
    private int lifePoints;
    @OneToOne
    @PrimaryKeyJoinColumn
    @MapsId
    private final Bag bag;
    @OneToOne
    @PrimaryKeyJoinColumn
    @MapsId
    private Room currentRoom;
    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag();
    }
}

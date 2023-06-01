package it.alten.game.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(force = true)
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "player")
public class Player {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lifepoints")
    private int lifePoints;
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "id_bag")
    private final Bag bag;


    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", lifePoints=" + lifePoints +
                '}';
    }
}

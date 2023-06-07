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
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "lifepoints",nullable = false)
    private int lifePoints;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id_bag")
    private Bag bag;
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id_room")
    private Room room;

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", lifePoints=" + lifePoints +
                '}';
    }

}

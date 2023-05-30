package it.alten.animal.model;

import it.alten.game.model.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@SuperBuilder
@NoArgsConstructor
@Entity
public class Lion extends AnimalWithTail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;

    public Lion(String name, String favouriteFood, int age, LocalDate dateOfJoin, double weight, double height, int id, double tailLength) {
        super(name, favouriteFood, age, dateOfJoin, weight, height, id, tailLength);
    }
}

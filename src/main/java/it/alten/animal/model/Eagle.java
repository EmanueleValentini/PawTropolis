package it.alten.animal.model;

import it.alten.game.model.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eagle")
public class Eagle extends AnimalWithWings{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "favfood")

    private String favouriteFood;
    @Column(name = "age")

    private int age;
    @Column(name = "dateofjoin")

    private LocalDate dateOfJoin;
    @Column(name = "weight")

    private double weight;
    @Column(name = "height")

    private double height;
    @Column(name = "wingspan")

    private double wingspan;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Eagle eagle = (Eagle) o;
        return id == eagle.id && Objects.equals(room, eagle.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, room);
    }

    @Override
    public String toString() {
        return name;
    }
}

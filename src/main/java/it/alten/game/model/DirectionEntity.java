package it.alten.game.model;

import it.alten.game.model.enums.Direction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "direction")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DirectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private Direction direction;
}

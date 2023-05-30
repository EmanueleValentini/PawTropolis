package it.alten.game.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room_connection")
public class RoomConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_room1")
    private Room room1;

    @ManyToOne
    @JoinColumn(name = "id_room2")
    private Room room2;

    @ManyToOne
    @JoinColumn(name = "direction")
    private DirectionEntity direction;
}

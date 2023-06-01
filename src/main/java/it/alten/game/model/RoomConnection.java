package it.alten.game.model;


import it.alten.game.model.enums.Direction;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "room_connection")
@ToString
public class RoomConnection {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_room1")
    private Room currentRoom;

    @ManyToOne
    @JoinColumn(name = "id_room2")
    private Room newRoom;

    @Column(name = "id_direction")
    private Direction direction;
}

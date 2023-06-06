package it.alten.game.repository;

import it.alten.game.model.Room;
import it.alten.game.model.RoomConnection;
import it.alten.game.model.enums.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomConnectionRepository extends JpaRepository<RoomConnection,Integer> {

    List<RoomConnection> findAllByCurrentRoom(Room room);

    RoomConnection findByCurrentRoomAndDirection(Room room, Direction direction);

    RoomConnection findById (int id);

}

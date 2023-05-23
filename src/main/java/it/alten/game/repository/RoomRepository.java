package it.alten.game.repository;

import it.alten.game.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    Optional<Room> findRoomByName (String name);
}

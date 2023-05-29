package it.alten.game.repository;

import it.alten.game.model.ItemInRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemInRoomRepository extends JpaRepository<ItemInRoom,Integer> {
    Optional<ItemInRoom> findByName(String name);
}
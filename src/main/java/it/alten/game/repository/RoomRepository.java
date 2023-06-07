package it.alten.game.repository;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    Optional<Room> findRoomByName (String name);


    Room findByIsPlayerInTrue();
    @Transactional
    @Modifying
    @Query("UPDATE Room r SET r.isPlayerIn = :isPlayerIn WHERE r.id = :id")
    void updateIsPlayerInById(@Param("id") int id,@Param("isPlayerIn") boolean isPlayerIn);
}

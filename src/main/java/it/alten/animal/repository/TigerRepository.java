package it.alten.animal.repository;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Tiger;
import it.alten.game.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TigerRepository extends JpaRepository<Tiger, Integer> {

    List<Tiger> findByRoom(Room room);

}

package it.alten.animal.repository;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Lion;
import it.alten.game.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LionRepository extends JpaRepository<Lion, Integer> {

    List<Lion> findByRoom(Room room);

}

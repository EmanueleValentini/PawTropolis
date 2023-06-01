package it.alten.game.repository;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

}

package it.alten.game.repository;

import it.alten.game.model.ItemInBag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemInBagRepository extends JpaRepository<ItemInBag,Integer> {
    Optional<ItemInBag> findByName(String name);

    @Query("SELECT SUM(requestedSlots) FROM ItemInBag")
    Integer sumFields();

    void deleteByName(String name);
}

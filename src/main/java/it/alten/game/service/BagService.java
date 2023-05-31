package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.BagDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BagService {

    Bag save (Bag bag);

    List<Bag> findAll ();

    Bag findById (int id);
}

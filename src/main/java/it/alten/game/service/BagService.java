package it.alten.game.service;

import it.alten.game.model.Bag;
import org.springframework.stereotype.Service;

@Service
public interface BagService {

    Bag save (Bag bag);

    Bag findById (int id);
}

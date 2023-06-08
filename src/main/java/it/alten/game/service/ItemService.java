package it.alten.game.service;

import it.alten.game.model.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemService <T extends Item>{


    boolean deleteById (int id);

    boolean deleteByName (String name);
}

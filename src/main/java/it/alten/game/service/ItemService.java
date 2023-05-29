package it.alten.game.service;

import it.alten.game.model.Item;
import it.alten.game.model.dto.ItemDto;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    Item save (ItemDto itemDto);

    Class<? extends Item> findByName (String name);

    Item findById (int id);

    boolean deleteById (int id);
}

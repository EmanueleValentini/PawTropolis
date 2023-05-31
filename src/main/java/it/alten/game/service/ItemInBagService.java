package it.alten.game.service;

import it.alten.game.model.Item;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemInBagDto;

import java.util.List;

public interface ItemInBagService extends ItemService<ItemInBag> {

    ItemInBag save (Item item);

    List<ItemInBag> findAll();
}

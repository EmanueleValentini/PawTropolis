package it.alten.game.service;

import it.alten.game.model.ItemInBag;
import it.alten.game.model.ItemInRoom;

import java.util.List;

public interface ItemInBagService extends ItemService<ItemInBag> {

    ItemInBag save (ItemInRoom item);

    List<ItemInBag> findAll();

    ItemInBag findByName(String name);

    Integer sumFields();
}

package it.alten.game.service;

import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemInBagDto;

import java.util.List;

public interface ItemInBagService extends ItemService<ItemInBag> {

    ItemInBag save (ItemInBagDto itemInBagDto);

    List<ItemInBag> findAll();
}

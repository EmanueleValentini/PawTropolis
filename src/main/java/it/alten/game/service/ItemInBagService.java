package it.alten.game.service;

import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemInBagDto;

public interface ItemInBagService extends ItemService<ItemInBag> {

    ItemInBag save (ItemInBagDto itemInBagDto);
}

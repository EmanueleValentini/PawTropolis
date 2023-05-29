package it.alten.game.service;

import it.alten.game.model.ItemInRoom;
import it.alten.game.model.dto.ItemInBagDto;

public interface ItemInRoomService extends ItemService<ItemInRoom> {

    ItemInRoom save(ItemInBagDto item);
}

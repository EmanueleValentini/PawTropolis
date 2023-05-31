package it.alten.game.service;

import it.alten.game.model.ItemInRoom;
import it.alten.game.model.Room;
import it.alten.game.model.dto.ItemInBagDto;

import java.util.List;

public interface ItemInRoomService extends ItemService<ItemInRoom> {

    ItemInRoom save(ItemInBagDto item);

    List<ItemInRoom> findAll();

    List<ItemInRoom> findAllByRoom(Room room);
}

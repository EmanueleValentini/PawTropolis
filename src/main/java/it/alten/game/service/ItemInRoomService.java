package it.alten.game.service;

import it.alten.game.model.ItemInBag;
import it.alten.game.model.ItemInRoom;
import it.alten.game.model.Room;

import java.util.List;


public interface ItemInRoomService extends ItemService<ItemInRoom> {

    ItemInRoom save(ItemInBag item);

    List<ItemInRoom> findAll();

    List<ItemInRoom> findByRoom(Room room);

    ItemInRoom findByName (String name);

    ItemInRoom findByRoomAndName (Room room, String name);
}

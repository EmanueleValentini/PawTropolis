package it.alten.game.service;

import it.alten.game.model.ItemInRoom;
import it.alten.game.model.Room;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.model.dto.ItemInRoomDto;

import java.util.List;


public interface ItemInRoomService extends ItemService<ItemInRoom> {

    void save(ItemInBagDto item);

    List<ItemInRoomDto> findAll();

    List<ItemInRoomDto> findByRoom(Room room);

    ItemInRoomDto findByName (String name);

    ItemInRoomDto findByRoomAndName (Room room, String name);

    boolean deleteByName(String name);

    ItemInRoomDto findById(int id);
}

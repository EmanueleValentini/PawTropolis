package it.alten.game.service;

import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.model.dto.ItemInRoomDto;

import java.util.List;

public interface ItemInBagService extends ItemService<ItemInBag> {

    void save (ItemInRoomDto item);

    List<ItemInBagDto> findAll();

    ItemInBagDto findByName(String name);

    Integer sumFields();

    boolean deleteByName(String name);
}

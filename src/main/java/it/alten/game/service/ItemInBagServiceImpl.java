package it.alten.game.service;

import it.alten.game.model.Item;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.ItemInRoom;
import it.alten.game.model.dto.ItemDto;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.model.dto.ItemInRoomDto;
import it.alten.game.repository.ItemInBagRepository;
import it.alten.game.repository.ItemInRoomRepository;
import it.alten.game.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImpl <T extends Item> implements ItemService <T> {

    private final ItemInBagRepository itemInBagRepository;
    private final ItemInRoomRepository itemInRoomRepository;

    @Autowired
    public ItemServiceImpl(ItemInBagRepository itemInBagRepository, ItemInRoomRepository itemInRoomRepository) {
        this.itemInBagRepository = itemInBagRepository;
        this.itemInRoomRepository = itemInRoomRepository;
    }

    @Override
    public T findByName(String name) {
        return itemRepository.findByName(name).orElse(null);
    }

    @Override
    public T findById(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        try {
            T itemToDelete = itemRepository.findById(id).orElse(null);
            if (itemToDelete instanceof ItemInBag) {
                itemRepository.save();
                itemRepository.deleteById(id);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Item save(ItemDto itemDto) {
        return null;
    }

    @Override
    public ItemInBag save(ItemInBagDto itemInBagDto) {
        return null;
    }

    @Override
    public ItemInRoom save(ItemInRoomDto itemInRoomDto) {
        return null;
    }
}

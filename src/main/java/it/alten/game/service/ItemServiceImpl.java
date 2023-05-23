package it.alten.game.service;

import it.alten.game.model.Item;
import it.alten.game.model.dto.ItemDto;
import it.alten.game.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(ItemDto itemDto) {
        ModelMapper modelMapper = new ModelMapper();
        Item itemSaved = modelMapper.map(itemDto,Item.class);
        itemRepository.save(itemSaved);
        return itemSaved;
    }

    @Override
    public Item findByName(String name) {
        Optional<Item> itemOptional = itemRepository.findItemByName(name);
        return itemOptional.orElse(null);
    }

    @Override
    public Item findById(int id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        return itemOptional.orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        try {
            itemRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package it.alten.game.service;

import it.alten.game.model.Item;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.repository.ItemInBagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemInBagServiceImpl implements ItemInBagService {

    private final ItemInBagRepository itemInBagRepository;

    @Autowired
    public ItemInBagServiceImpl(ItemInBagRepository itemInBagRepository) {
        this.itemInBagRepository = itemInBagRepository;
    }

    @Override
    public ItemInBag findByName(String name) {
        return itemInBagRepository.findByName(name).orElse(null);
    }

    @Override
    public ItemInBag findById(int id) {
        return itemInBagRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        try {
            itemInBagRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ItemInBag save(Item item) {
        return itemInBagRepository.save((ItemInBag) item);

    }

    @Override
    public List<ItemInBag> findAll() {
        return itemInBagRepository.findAll();
    }


}

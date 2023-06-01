package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.ItemInRoom;
import it.alten.game.repository.BagRepository;
import it.alten.game.repository.ItemInBagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemInBagServiceImpl implements ItemInBagService {

    private final ItemInBagRepository itemInBagRepository;

    private final BagRepository bagRepository;

    @Autowired
    public ItemInBagServiceImpl(ItemInBagRepository itemInBagRepository, BagRepository bagRepository) {
        this.itemInBagRepository = itemInBagRepository;
        this.bagRepository = bagRepository;
    }

    @Override
    public ItemInBag findByName(String name) {
        return itemInBagRepository.findByName(name).orElse(null);
    }

    @Override
    public int sumFields() {
        if (itemInBagRepository.sumField() == 0){
            return 0;
        }
        return itemInBagRepository.sumField();
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
    public ItemInBag save(ItemInRoom item) {
    ItemInBag itemInBag = new ItemInBag();
    Bag bag = bagRepository.findById(1).orElse(null);
    itemInBag.setName(item.getName());
    itemInBag.setDescription(item.getDescription());
    itemInBag.setRequestedSlots(item.getRequestedSlots());
    itemInBag.setBag(bag);
        return itemInBagRepository.save(itemInBag);

    }

    @Override
    public List<ItemInBag> findAll() {
        return itemInBagRepository.findAll();
    }


}

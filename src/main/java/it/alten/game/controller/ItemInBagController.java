package it.alten.game.controller;

import it.alten.game.model.Item;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.service.ItemInBagService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
public class ItemInBagController {
    private final ItemInBagService itemInBagService;

    @Autowired
    public ItemInBagController(ItemInBagService itemInBagService) {
        this.itemInBagService = itemInBagService;
    }

    public ItemInBag findByName (String name) {
        return itemInBagService.findByName(name);
    }

    public ItemInBag save(Item item) {
        return itemInBagService.save(item);

    }

    public List<ItemInBag> findAll() {
        return itemInBagService.findAll();
    }

    public void deleteById(int id) {
        itemInBagService.deleteById(id);
    }
}

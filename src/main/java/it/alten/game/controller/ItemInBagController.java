package it.alten.game.controller;

import it.alten.game.model.Item;
import it.alten.game.service.ItemInBagService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class ItemController {

    private final ItemInBagService itemInBagService;

    @Autowired
    public ItemController(ItemInBagService itemInBagService) {
        this.itemInBagService = itemInBagService;
    }

    public Class<? extends Item>  findByName(String name) {
        return itemInBagService.findByName(name);
    }
}

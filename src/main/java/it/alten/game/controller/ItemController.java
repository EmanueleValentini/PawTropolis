package it.alten.game.controller;

import it.alten.game.model.Item;
import it.alten.game.service.ItemService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    public Class<? extends Item>  findByName(String name) {
        return itemService.findByName(name);
    }
}

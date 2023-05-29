package it.alten.game.controller;

import it.alten.game.model.ItemInBag;
import it.alten.game.service.ItemInBagService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}

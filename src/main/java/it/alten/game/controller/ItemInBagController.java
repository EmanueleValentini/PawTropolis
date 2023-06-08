package it.alten.game.controller;

import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.model.dto.ItemInRoomDto;
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

    public ItemInBagDto findByName (String name) {
        return itemInBagService.findByName(name);
    }

    public void save(ItemInRoomDto item) {
        itemInBagService.save(item);

    }

    public List<ItemInBagDto> findAll() {
        return itemInBagService.findAll();
    }

    public void deleteById(int id) {
        itemInBagService.deleteById(id);
    }

    public Integer sumFields() {
        return itemInBagService.sumFields();
    }

    public boolean deleteByName(String name) {
        return itemInBagService.deleteByName(name);
    }
}

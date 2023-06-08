package it.alten.game.controller;

import it.alten.game.model.Room;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.model.dto.ItemInRoomDto;
import it.alten.game.service.ItemInRoomService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
public class ItemInRoomController {
    private final ItemInRoomService itemInRoomService;

    @Autowired
    public ItemInRoomController(ItemInRoomService itemInRoomService) {
        this.itemInRoomService = itemInRoomService;
    }

    public ItemInRoomDto findByName (String name) {
        return itemInRoomService.findByName(name);
    }

    public List<ItemInRoomDto> findByRoom(Room room) {
        return itemInRoomService.findByRoom(room);
    }

    public void save(ItemInBagDto item) {
        itemInRoomService.save(item);
    }

    public void deleteById(int id) {
        itemInRoomService.deleteById(id);
    }

    public ItemInRoomDto findByRoomAndName(Room room, String name){
        return itemInRoomService.findByRoomAndName(room, name);
    }

    public boolean deleteByName(String name) {
        return itemInRoomService.deleteByName(name);
    }
}

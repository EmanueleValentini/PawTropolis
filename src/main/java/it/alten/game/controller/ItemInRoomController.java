package it.alten.game.controller;

import it.alten.game.model.ItemInRoom;
import it.alten.game.model.Room;
import it.alten.game.model.dto.ItemInBagDto;
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

    public ItemInRoom findByName (String name) {
        return itemInRoomService.findByName(name);
    }

    public List<ItemInRoom> findAllByRoom(Room room) {
        return itemInRoomService.findAllByRoom(room);
    }

    public ItemInRoom save(ItemInBagDto item) {
        return itemInRoomService.save(item);
    }
}

package it.alten.game.controller;

import it.alten.game.model.ItemInBag;
import it.alten.game.model.ItemInRoom;
import it.alten.game.model.Room;
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

    public List<ItemInRoom> findByRoom(Room room) {
        return itemInRoomService.findByRoom(room);
    }

    public ItemInRoom save(ItemInBag item) {
        return itemInRoomService.save(item);
    }

    public void deleteById(int id) {
        itemInRoomService.deleteById(id);
    }

    public ItemInRoom findByRoomAndName(Room room, String name){
        return itemInRoomService.findByRoomAndName(room, name);
    }
}

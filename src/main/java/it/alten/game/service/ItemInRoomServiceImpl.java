package it.alten.game.service;

import it.alten.game.model.*;
import it.alten.game.repository.ItemInRoomRepository;
import it.alten.game.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemInRoomServiceImpl implements ItemInRoomService {

    private final ItemInRoomRepository itemInRoomRepository;
    private  final RoomRepository roomRepository;

    @Autowired
    public ItemInRoomServiceImpl(ItemInRoomRepository itemInRoomRepository, RoomRepository roomRepository) {
        this.itemInRoomRepository = itemInRoomRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public ItemInRoom findByName(String name) {
        return itemInRoomRepository.findByName(name).orElse(null);
    }

    @Override
    public ItemInRoom findByRoomAndName(Room room, String name) {
        return itemInRoomRepository.findByRoomAndName(room, name).orElse(null);
    }

    @Override
    public ItemInRoom findById(int id) {
        return itemInRoomRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        try {
            itemInRoomRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ItemInRoom save(ItemInBag item) {
        ItemInRoom itemInRoom = new ItemInRoom();
        Room room = roomRepository.findByPlayer(true);
        itemInRoom.setName(item.getName());
        itemInRoom.setDescription(item.getDescription());
        itemInRoom.setRequestedSlots(item.getRequestedSlots());
        itemInRoom.setRoom(room);
        return itemInRoomRepository.save(itemInRoom);


    }

    @Override
    public List<ItemInRoom> findAll() {
        return itemInRoomRepository.findAll();
    }

    @Override
    public List<ItemInRoom> findByRoom(Room room) {
        return itemInRoomRepository.findByRoom(room);
    }
}

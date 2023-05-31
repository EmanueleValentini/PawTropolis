package it.alten.game.service;

import it.alten.game.model.ItemInRoom;
import it.alten.game.model.Room;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.repository.ItemInRoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemInRoomServiceImpl implements ItemInRoomService {

    private final ItemInRoomRepository itemInRoomRepository;

    @Autowired
    public ItemInRoomServiceImpl(ItemInRoomRepository itemInRoomRepository) {
        this.itemInRoomRepository = itemInRoomRepository;
    }

    @Override
    public ItemInRoom findByName(String name) {
        return itemInRoomRepository.findByName(name).orElse(null);
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
    public ItemInRoom save(ItemInBagDto item) {
        ModelMapper modelMapper = new ModelMapper();
        ItemInRoom itemSaved = modelMapper.map(item,ItemInRoom.class);
        itemInRoomRepository.save(itemSaved);
        return itemSaved;
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

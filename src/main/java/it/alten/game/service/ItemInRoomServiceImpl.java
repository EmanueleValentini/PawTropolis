package it.alten.game.service;

import it.alten.game.model.ItemInRoom;
import it.alten.game.model.Room;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.model.dto.ItemInRoomDto;
import it.alten.game.repository.ItemInRoomRepository;
import it.alten.game.utils.mapper.ItemInRoomMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemInRoomServiceImpl implements ItemInRoomService {

    private final ItemInRoomRepository itemInRoomRepository;

    private final ItemInRoomMapper itemInRoomMapper;

    @Autowired
    public ItemInRoomServiceImpl(ItemInRoomRepository itemInRoomRepository, ItemInRoomMapper itemInRoomMapper) {
        this.itemInRoomRepository = itemInRoomRepository;
        this.itemInRoomMapper = itemInRoomMapper;
    }

    @Override
    public ItemInRoomDto findByName(String name) {
        Optional<ItemInRoom> itemInRoom = itemInRoomRepository.findByName(name);
        if (itemInRoom.isPresent()) {
            ItemInRoom itemInRoomPresent = itemInRoom.get();
            return itemInRoomMapper.toDto(itemInRoomPresent);
        }
        return null;
    }

    @Override
    public ItemInRoomDto findByRoomAndName(Room room, String name) {
        Optional<ItemInRoom> itemInRoom = itemInRoomRepository.findByRoomAndName(room, name);
        if (itemInRoom.isPresent()) {
            ItemInRoom itemInRoomPresent = itemInRoom.get();
            return itemInRoomMapper.toDto(itemInRoomPresent);
        }
        return null;
    }

    @Override
    public ItemInRoomDto findById(int id) {
        Optional<ItemInRoom> itemInRoom = itemInRoomRepository.findById(id);
        if (itemInRoom.isPresent()) {
            ItemInRoom itemInRoomPresent = itemInRoom.get();
            return itemInRoomMapper.toDto(itemInRoomPresent);
        }
        return null;
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
    public boolean deleteByName(String name) {
        try {
            itemInRoomRepository.deleteByName(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void save(ItemInBagDto item) {
        itemInRoomRepository.save(itemInRoomMapper.fromBagToRoom(item));
    }

    @Override
    public List<ItemInRoomDto> findAll() {
        List<ItemInRoomDto> itemInRoomDtoList = new ArrayList<>();
        List<ItemInRoom> itemInRoomList = itemInRoomRepository.findAll();
        for (ItemInRoom itemInRoom:itemInRoomList) {
            ItemInRoomDto itemInRoomDto = itemInRoomMapper.toDto(itemInRoom);
            itemInRoomDtoList.add(itemInRoomDto);
        }
        return itemInRoomDtoList;
    }

    @Override
    public List<ItemInRoomDto> findByRoom(Room room) {
        List<ItemInRoomDto> itemInRoomDtoList = new ArrayList<>();
        List<ItemInRoom> itemInRoomList = itemInRoomRepository.findByRoom(room);
        for (ItemInRoom itemInRoom:itemInRoomList) {
            ItemInRoomDto itemInRoomDto = itemInRoomMapper.toDto(itemInRoom);
            itemInRoomDtoList.add(itemInRoomDto);
        }
        return itemInRoomDtoList;
    }
}

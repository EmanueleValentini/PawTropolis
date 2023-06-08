package it.alten.game.service;

import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.model.dto.ItemInRoomDto;
import it.alten.game.repository.ItemInBagRepository;
import it.alten.game.utils.mapper.ItemInBagMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemInBagServiceImpl implements ItemInBagService {

    private final ItemInBagRepository itemInBagRepository;

    private final ItemInBagMapper itemInBagMapper;


    @Autowired
    public ItemInBagServiceImpl(ItemInBagRepository itemInBagRepository, ItemInBagMapper itemInBagMapper) {
        this.itemInBagRepository = itemInBagRepository;
        this.itemInBagMapper = itemInBagMapper;
    }

    @Override
    public ItemInBagDto findByName(String name) {
        Optional<ItemInBag> itemInBag = itemInBagRepository.findByName(name);
        if (itemInBag.isPresent()) {
            ItemInBag itemInBagPresent = itemInBag.get();
            return itemInBagMapper.toDto(itemInBagPresent);
        }
       return null;
    }

    @Override
    public Integer sumFields() {
        if (itemInBagRepository.sumFields() == null){
            return 0;
        }
        return itemInBagRepository.sumFields();
    }

    @Override
    public ItemInBagDto findById(int id) {
        Optional<ItemInBag> itemInBag = itemInBagRepository.findById(id);
        if (itemInBag.isPresent()) {
            ItemInBag itemInBagPresent = itemInBag.get();
            return itemInBagMapper.toDto(itemInBagPresent);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            itemInBagRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteByName(String name) {
        try {
            itemInBagRepository.deleteByName(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public void save(ItemInRoomDto item) {
    itemInBagRepository.save(itemInBagMapper.fromRoomToBag(item));

    }

    @Override
    public List<ItemInBagDto> findAll() {
        List<ItemInBagDto> itemInBagDtoList = new ArrayList<>();
        List<ItemInBag> itemInBagList = itemInBagRepository.findAll();
        for (ItemInBag itemInBag:itemInBagList) {
            ItemInBagDto itemInBagDto = itemInBagMapper.toDto(itemInBag);
            itemInBagDtoList.add(itemInBagDto);
        }
        return itemInBagDtoList;
    }


}

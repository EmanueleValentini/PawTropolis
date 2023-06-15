package it.alten.game.utils.mapper;

import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.model.dto.ItemInRoomDto;
import it.alten.game.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemInBagMapper {

    private final BagRepository bagRepository;

    @Autowired
    public ItemInBagMapper(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    public ItemInBagDto toDto(ItemInBag itemInBag) {
        ItemInBagDto itemInBagDto = new ItemInBagDto();
        itemInBagDto.setIdBag(itemInBag.getBag().getId());
        itemInBagDto.setName(itemInBag.getName());
        itemInBagDto.setDescription(itemInBag.getDescription());
        itemInBagDto.setRequestedSlots(itemInBag.getRequestedSlots());
        return itemInBagDto;
    }

    public ItemInBag toEntity(ItemInBagDto itemInBagDto) {
        ItemInBag itemInBag = new ItemInBag();
        itemInBag.setBag(bagRepository.findById(itemInBagDto.getIdBag()).orElse(null));
        itemInBag.setDescription(itemInBagDto.getDescription());
        itemInBag.setName(itemInBagDto.getName());
        itemInBag.setRequestedSlots(itemInBagDto.getRequestedSlots());
        return itemInBag;
    }

    public ItemInBag fromRoomToBag(ItemInRoomDto itemInRoomDto) {
        ItemInBag itemInBag = new ItemInBag();
        itemInBag.setBag(bagRepository.findById(1).orElse(null));
        itemInBag.setDescription(itemInRoomDto.getDescription());
        itemInBag.setName(itemInRoomDto.getName());
        itemInBag.setRequestedSlots(itemInRoomDto.getRequestedSlots());
        return itemInBag;
    }

}

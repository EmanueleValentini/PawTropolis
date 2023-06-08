package it.alten.game.utils.mapper;

import it.alten.game.model.ItemInRoom;
import it.alten.game.model.dto.ItemInBagDto;
import it.alten.game.model.dto.ItemInRoomDto;
import it.alten.game.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemInRoomMapper {

    private final RoomRepository roomRepository;

    @Autowired
    public ItemInRoomMapper(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public ItemInRoom toEntity(ItemInRoomDto itemInRoomDto) {
        ItemInRoom itemInRoom = new ItemInRoom();
        itemInRoom.setRoom(roomRepository.findById(itemInRoomDto.getIdRoom()).orElse(null));
        itemInRoom.setName(itemInRoomDto.getName());
        itemInRoom.setDescription(itemInRoomDto.getDescription());
        itemInRoom.setRequestedSlots(itemInRoomDto.getRequestedSlots());
        return itemInRoom;
    }

    public ItemInRoomDto toDto(ItemInRoom itemInRoom) {
        ItemInRoomDto itemInRoomDto = new ItemInRoomDto();
        itemInRoomDto.setIdRoom(itemInRoom.getRoom().getId());
        itemInRoomDto.setDescription(itemInRoom.getDescription());
        itemInRoomDto.setName(itemInRoom.getName());
        itemInRoomDto.setRequestedSlots(itemInRoom.getRequestedSlots());
        return itemInRoomDto;
    }

    public ItemInRoom fromBagToRoom(ItemInBagDto itemInBagDto) {
        ItemInRoom itemInRoom = new ItemInRoom();
        itemInRoom.setRoom(roomRepository.findByIsPlayerInTrue());
        itemInRoom.setDescription(itemInBagDto.getDescription());
        itemInRoom.setName(itemInBagDto.getName());
        itemInRoom.setRequestedSlots(itemInBagDto.getRequestedSlots());
        return itemInRoom;
    }
}

package it.alten.game.utils.mapper;

import it.alten.game.model.Room;
import it.alten.game.model.dto.RoomDto;
import it.alten.game.repository.RoomRepository;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public RoomMapper(RoomRepository roomRepository) {
    }

    public Room toEntity(RoomDto roomDto) {
        Room room = new Room();
        room.setName(roomDto.getName());
        room.setPlayerIn(roomDto.isPlayerIn());
        return room;
    }

    public RoomDto toDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setName(room.getName());
        roomDto.setPlayerIn(room.isPlayerIn());
        return roomDto;
    }
}

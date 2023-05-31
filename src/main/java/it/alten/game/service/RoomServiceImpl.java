package it.alten.game.service;

import it.alten.game.model.Room;
import it.alten.game.model.dto.RoomDto;
import it.alten.game.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room save(RoomDto roomDto) {
        ModelMapper modelMapper = new ModelMapper();
        Room roomSaved = modelMapper.map(roomDto,Room.class);
        roomRepository.save(roomSaved);
        return roomSaved;
    }

    @Override
    public Room findByName(String name) {
        Optional<Room> roomOptional = roomRepository.findRoomByName(name);
        return roomOptional.orElse(null);
    }

    @Override
    public Room findById(int id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        return roomOptional.orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        try {
            roomRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findByPlayer(boolean isIn) {

        return roomRepository.findByPlayer(true);
    }
}

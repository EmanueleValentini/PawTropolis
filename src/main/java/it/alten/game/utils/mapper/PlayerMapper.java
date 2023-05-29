package it.alten.game.utils.mapper;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.repository.BagRepository;
import it.alten.game.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlayerMapper {

    private final ModelMapper modelMapper;

    private final BagRepository bagRepository;

    private final RoomRepository roomRepository;

    @Autowired
    public PlayerMapper(ModelMapper modelMapper, BagRepository bagRepository, RoomRepository roomRepository) {
        this.modelMapper = modelMapper;
        this.bagRepository = bagRepository;
        this.roomRepository = roomRepository;
    }

    public Player toEntity(PlayerDto playerDto) {
        Player player = modelMapper.map(playerDto, Player.class);
        if (playerDto.getRoom() != 0) {
            Optional<Room> roomOptional = roomRepository.findById(playerDto.getRoom());
            if (roomOptional.isPresent()) {
                Room room = roomOptional.get();
                player.setCurrentRoom(room);
            }
        } else {
            Optional<Room> roomOptional = roomRepository.findById(1);
            if (roomOptional.isPresent()) {
                Room room = roomOptional.get();
                player.setCurrentRoom(room);
            }
        }
        return player;
    }

    public PlayerDto toDTO (Player player) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName(player.getName());
        playerDto.setLifePoints(player.getLifePoints());
        if (player.getCurrentRoom() != null) {
            playerDto.setRoom(player.getCurrentRoom().getId());
        }
        if (player.getBag() != null){
            playerDto.setBag(player.getBag().getId());
        }
        return  playerDto;
    }
}

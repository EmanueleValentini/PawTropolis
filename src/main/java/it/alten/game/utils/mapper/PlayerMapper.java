package it.alten.game.utils.mapper;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.repository.PlayerRepository;
import it.alten.game.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlayerMapper {

    private final ModelMapper modelMapper;

    private final PlayerRepository playerRepository;

    private final RoomRepository roomRepository;

    @Autowired
    public PlayerMapper(ModelMapper modelMapper, PlayerRepository playerRepository, RoomRepository roomRepository) {
        this.modelMapper = modelMapper;
        this.playerRepository = playerRepository;
        this.roomRepository = roomRepository;
    }

    public Player toEntity(PlayerDto playerDto) {
        Player player = modelMapper.map(playerDto, Player.class);
        if (playerDto.getRoom() != 0) {
            Optional<Room> roomOptional = roomRepository.findById(playerDto.getRoom());
            if (roomOptional.isPresent()) {
                Room room = roomOptional.get();
                player.setRoom(room);
            }
        } else {
            Optional<Room> roomOptional = roomRepository.findById(1);
            if (roomOptional.isPresent()) {
                Room room = roomOptional.get();
                player.setRoom(room);
            }
        }
        return player;
    }

    public PlayerDto toDTO (Player player) {
        PlayerDto playerDto = new PlayerDto();
        if (player.getName() != null){
            playerDto.setName(player.getName());
        } else {
            playerDto.setName(playerRepository.findById(1).get().getName());
        }
        if (player.getLifePoints() != 0) {
            playerDto.setLifePoints(player.getLifePoints());
        } else {
            playerDto.setLifePoints(playerRepository.findById(1).get().getLifePoints());
        }
        if (player.getRoom() != null) {
            playerDto.setRoom(player.getRoom().getId());
        } else {
            playerDto.setRoom(playerRepository.findById(1).get().getRoom().getId());
        }
        if (player.getBag() != null){
            playerDto.setBag(player.getBag().getId());
        } else {
            playerDto.setBag(playerRepository.findById(1).get().getBag().getId());
        }
        return  playerDto;
    }
}

package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player save(PlayerDto playerDto) {
        ModelMapper modelMapper = new ModelMapper();
        Player playerSaved = modelMapper.map(playerDto,Player.class);
        playerRepository.save(playerSaved);
        return playerSaved;
    }

    @Override
    public Room findPlayerCurrentRoom(int id) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null){
            return player.getCurrentRoom();
        }
        else {
            return null;
        }
    }

    @Override
    public boolean updateCurrentRoomById(int id, Player player) {
        ModelMapper modelMapper = new ModelMapper();
        Player playerFound = playerRepository.findById(id).orElse(null);
        if (playerFound != null) {
            playerFound.setCurrentRoom(player.getCurrentRoom());
            PlayerDto playerDto = modelMapper.map(playerFound, PlayerDto.class);
            save(playerDto);
            return true;
        }
        return false;
    }
}

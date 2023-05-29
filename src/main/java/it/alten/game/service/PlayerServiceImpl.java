package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.repository.PlayerRepository;
import it.alten.game.utils.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    @Override
    public Player save(PlayerDto playerDto) {
        Player player = playerMapper.toEntity(playerDto);
        playerRepository.save(player);
        return player;
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
        Player playerFound = playerRepository.findById(id).orElse(null);
        if (playerFound != null) {
            playerFound.setCurrentRoom(player.getCurrentRoom());
            PlayerDto playerDto = playerMapper.toDTO(player);
            save(playerDto);
            return true;
        }
        return false;
    }
}

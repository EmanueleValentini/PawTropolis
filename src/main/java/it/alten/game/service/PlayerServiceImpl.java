package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.repository.BagRepository;
import it.alten.game.repository.PlayerRepository;
import it.alten.game.repository.RoomRepository;
import it.alten.game.utils.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    private final RoomRepository roomRepository;

    private final BagRepository bagRepository;

    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, RoomRepository roomRepository, BagRepository bagRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.roomRepository = roomRepository;
        this.bagRepository = bagRepository;
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
            return player.getRoom();
        }
        else {
            return null;
        }
    }

    @Override
    public boolean updateCurrentRoomById(int id, Player player) {
        Player playerFound = playerRepository.findById(id).orElse(null);
        if (playerFound != null) {
            playerFound.setRoom(player.getRoom());
            PlayerDto playerDto = playerMapper.toDTO(player);
            save(playerDto);
            return true;
        }
        return false;
    }

    @Override
    public Player findById(int id) {
        return playerRepository.findById(id).orElse(null);
    }


    @Override
    public void saveOrUpdate(PlayerDto playerDto) {
        Player player = playerRepository.findById(1).orElse(null);

        if (player == null) {
            // Player non esistente, creazione di una nuova istanza
            player = new Player();
        }

        // Aggiornamento dei campi
        player.setName(playerDto.getName());
        player.setLifePoints(playerDto.getLifePoints());
        Room room = roomRepository.findById(playerDto.getRoom()).orElse(null);
        player.setRoom(room);
        Bag bag = bagRepository.findById(playerDto.getBag()).orElse(null);
        player.setBag(bag);

        playerRepository.save(player);
    }
}

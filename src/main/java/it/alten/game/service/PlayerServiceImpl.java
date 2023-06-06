package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }


    @Override
    public boolean updateCurrentRoomById(int id, Player player) {
      //  Player playerFound = playerRepository.findById(id).orElse(null);
       // if (playerFound != null) {
         //   playerFound.setRoom(player.getRoom());
           // ModelMapper mapper = new ModelMapper();
          //PlayerDto playerDto =  mapper.map(player, PlayerDto.class);
           // save(playerDto);
            //return true;
       // }
        return false;
    }

    @Override
    public Player findById(int id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public void updatePlayerRoom(Room room) {
        playerRepository.findById(1).ifPresent(player -> player.setRoom(room));
    }
}

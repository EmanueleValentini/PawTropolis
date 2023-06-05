package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.repository.BagRepository;
import it.alten.game.repository.PlayerRepository;
import it.alten.game.repository.RoomRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    private final RoomRepository roomRepository;

    private final BagRepository bagRepository;



    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, RoomRepository roomRepository, BagRepository bagRepository) {
        this.playerRepository = playerRepository;
        this.roomRepository = roomRepository;
        this.bagRepository = bagRepository;
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
}

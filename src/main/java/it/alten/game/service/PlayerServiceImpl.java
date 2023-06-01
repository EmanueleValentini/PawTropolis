package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.repository.BagRepository;
import it.alten.game.repository.PlayerRepository;
import it.alten.game.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        playerRepository.save(player);
        return player;
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

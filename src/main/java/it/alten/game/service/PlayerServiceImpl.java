package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.model.Player;
import it.alten.game.model.Room;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.repository.BagRepository;
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

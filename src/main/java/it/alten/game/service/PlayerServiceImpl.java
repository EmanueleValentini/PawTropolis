package it.alten.game.service;

import it.alten.game.model.Player;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
}

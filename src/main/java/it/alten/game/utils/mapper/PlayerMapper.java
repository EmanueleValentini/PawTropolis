package it.alten.game.utils.mapper;

import it.alten.game.model.Player;
import it.alten.game.model.dto.PlayerDto;
import it.alten.game.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    private final BagRepository bagRepository;

    @Autowired
    public PlayerMapper(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    public Player toEntity (PlayerDto playerDto) {
        Player player = new Player();
        player.setName(playerDto.getName());
        player.setLifePoints(playerDto.getLifePoints());
        player.setBag(bagRepository.findById(playerDto.getIdBag()).orElse(null));
        return player;
    }

    public PlayerDto toDto (Player player) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName(player.getName());
        playerDto.setIdBag(player.getBag().getId());
        playerDto.setLifePoints(player.getLifePoints());
        return playerDto;
    }
}

package it.alten.game.utils.mapper;

import it.alten.game.model.Bag;
import it.alten.game.model.dto.BagDto;
import it.alten.game.repository.BagRepository;
import it.alten.game.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BagMapper {

    private final ModelMapper modelMapper;

    private final BagRepository bagRepository;

    private final PlayerRepository playerRepository;

    @Autowired
    public BagMapper(ModelMapper modelMapper, BagRepository bagRepository, PlayerRepository playerRepository) {
        this.modelMapper = modelMapper;
        this.bagRepository = bagRepository;
        this.playerRepository = playerRepository;
    }

    public Bag toEntity(BagDto bagDto) {
        Bag bag = new Bag();
        bag.setPlayer(playerRepository.findById(bagDto.getIdPlayer()).orElse(null));
        bag.setSlots(bagDto.getSlots());
        return bag;
    }

    public BagDto toDTO(Bag bag) {
        BagDto bagDto = new BagDto();
        bagDto.setIdPlayer(bag.getPlayer().getId());
        bagDto.setSlots(bag.getSlots());
        return bagDto;
    }
}

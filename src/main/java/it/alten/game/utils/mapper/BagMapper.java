package it.alten.game.utils.mapper;

import it.alten.game.model.Bag;
import it.alten.game.model.dto.BagDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BagMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public BagMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Bag toEntity(BagDto bagDto) {
        return modelMapper.map(bagDto, Bag.class);
    }

    public BagDto toDTO(Bag bag) {
        return modelMapper.map(bag, BagDto.class);
    }
}

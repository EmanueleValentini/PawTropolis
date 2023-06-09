package it.alten.animal.utils.mapper;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.dto.EagleDto;
import it.alten.game.model.Bag;
import it.alten.game.model.dto.BagDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EagleMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public EagleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

    }

    public void toEntity(EagleDto eagleDto) {
        modelMapper.map(eagleDto, Eagle.class);
    }

    public void toDTO(Bag bag) {
        modelMapper.map(bag, BagDto.class);
    }

}

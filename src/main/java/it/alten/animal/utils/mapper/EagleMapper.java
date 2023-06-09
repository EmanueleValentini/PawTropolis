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

    public Eagle toEntity(EagleDto eagleDto) {
        return modelMapper.map(eagleDto, Eagle.class);
    }

    public EagleDto toDTO(Eagle eagle) {
        return modelMapper.map(eagle, EagleDto.class);
    }

}

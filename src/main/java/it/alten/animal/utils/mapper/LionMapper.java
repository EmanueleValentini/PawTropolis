package it.alten.animal.utils.mapper;
import it.alten.animal.model.Lion;
import it.alten.animal.model.dto.LionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LionMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public LionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

    }

    public Lion toEntity(LionDto lionDto) {
        return modelMapper.map(lionDto, Lion.class);

    }

    public LionDto toDTO(Lion lion) {
        return modelMapper.map(lion, LionDto.class);
    }
}

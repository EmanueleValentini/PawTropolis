package it.alten.animal.utils.mapper;
import it.alten.animal.model.Tiger;
import it.alten.animal.model.dto.TigerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TigerMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public TigerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

    }

    public Tiger toEntity(TigerDto tigerDto) {
        return modelMapper.map(tigerDto, Tiger.class);

    }

    public TigerDto toDTO(Tiger tiger) {
        return modelMapper.map(tiger, TigerDto.class);
    }
}

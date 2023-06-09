package it.alten.animal.service;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.dto.EagleDto;
import it.alten.animal.repository.EagleRepository;
import it.alten.animal.utils.mapper.EagleMapper;
import it.alten.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EagleServiceImpl implements EagleService{

   private final EagleRepository eagleRepository;

   private final EagleMapper eagleMapper;

    @Autowired
    public EagleServiceImpl(EagleRepository eagleRepository, EagleMapper eagleMapper) {
        this.eagleRepository = eagleRepository;
        this.eagleMapper = eagleMapper;
    }

    @Override
    public List<Eagle> findByRoom(Room room) {
        return eagleRepository.findByRoom(room);
    }

    @Override
    public void save(EagleDto eagleDto) {
        Eagle eagle = eagleMapper.toEntity(eagleDto);
        eagleRepository.save(eagle);

    }
}

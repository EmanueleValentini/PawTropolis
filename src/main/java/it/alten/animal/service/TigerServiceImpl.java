package it.alten.animal.service;

import it.alten.animal.model.Tiger;
import it.alten.animal.model.dto.TigerDto;
import it.alten.animal.repository.TigerRepository;
import it.alten.animal.utils.mapper.TigerMapper;
import it.alten.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TigerServiceImpl implements TigerService{


    private  final TigerRepository tigerRepository;

    private final TigerMapper tigerMapper;

    @Autowired
    public TigerServiceImpl(TigerRepository tigerRepository, TigerMapper tigerMapper) {
        this.tigerRepository = tigerRepository;
        this.tigerMapper = tigerMapper;
    }

    @Override
    public List<Tiger> findByRoom(Room room) {
        return tigerRepository.findByRoom(room);
    }

    @Override
    public void save(TigerDto tigerDto) {
       Tiger tiger = tigerMapper.toEntity(tigerDto);
        tigerRepository.save(tiger);
    }


}

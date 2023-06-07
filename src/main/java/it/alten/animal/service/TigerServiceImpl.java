package it.alten.animal.service;

import it.alten.animal.model.Tiger;
import it.alten.animal.repository.TigerRepository;
import it.alten.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TigerServiceImpl implements TigerService{


    private  final TigerRepository tigerRepository;

    @Autowired
    public TigerServiceImpl(TigerRepository tigerRepository) {
        this.tigerRepository = tigerRepository;
    }

    @Override
    public List<Tiger> findByRoom(Room room) {
        return tigerRepository.findByRoom(room);
    }


}

package it.alten.animal.service;

import it.alten.animal.model.Eagle;
import it.alten.animal.repository.EagleRepository;
import it.alten.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EagleServiceImpl implements EagleService{

   private final EagleRepository eagleRepository;

    @Autowired
    public EagleServiceImpl(EagleRepository eagleRepository) {
        this.eagleRepository = eagleRepository;
    }

    @Override
    public List<Eagle> findByRoom(Room room) {
        return eagleRepository.findByRoom(room);
    }
}

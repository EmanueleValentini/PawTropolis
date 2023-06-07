package it.alten.animal.service;

import it.alten.animal.model.Eagle;
import it.alten.animal.model.Lion;
import it.alten.animal.repository.LionRepository;
import it.alten.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LionServiceImpls implements LionService{

    private  final LionRepository lionRepository;

    @Autowired
    public LionServiceImpls(LionRepository lionRepository) {
        this.lionRepository = lionRepository;
    }

    @Override
    public List<Lion> findByRoom(Room room) {
        return lionRepository.findByRoom(room);
    }
}

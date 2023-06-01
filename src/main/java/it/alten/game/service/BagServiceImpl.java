package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BagServiceImpl implements BagService{

    private final BagRepository bagRepository;

    @Autowired
    public BagServiceImpl(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    @Override
    public Bag save(Bag bag) {

        return bagRepository.save(bag);
    }

    @Override
    public Bag findById(int id) {
        Optional<Bag> opt = bagRepository.findById(id);

        return opt.orElse(null);
    }
}

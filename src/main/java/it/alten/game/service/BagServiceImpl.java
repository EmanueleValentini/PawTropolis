package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.model.ItemInBag;
import it.alten.game.model.dto.BagDto;
import it.alten.game.repository.BagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<Bag> findAll() {
        return bagRepository.findAll();
    }

    @Override
    public Bag findById(int id) {
        Optional<Bag> opt = bagRepository.findById(id);

        return opt.orElse(null);
    }
}

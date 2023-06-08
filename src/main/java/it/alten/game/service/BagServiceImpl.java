package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.model.dto.BagDto;
import it.alten.game.repository.BagRepository;
import it.alten.game.utils.mapper.BagMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class BagServiceImpl implements BagService{

    private final BagRepository bagRepository;

    private final BagMapper bagMapper;

    @Autowired
    public BagServiceImpl(BagRepository bagRepository, BagMapper bagMapper) {
        this.bagRepository = bagRepository;
        this.bagMapper = bagMapper;
    }

    @Override
    public void save(BagDto bagDto) {
        Bag bag = bagMapper.toEntity(bagDto);
        bagRepository.save(bag);
    }

    @Override
    public BagDto findById(int id) {
        Optional<Bag> opt = bagRepository.findById(id);
        if (opt.isPresent()) {
            Bag bagPresent = opt.get();
            return bagMapper.toDTO(bagPresent);
        }
        return null;
    }
}

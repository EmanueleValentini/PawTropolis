package it.alten.game.service;

import it.alten.game.model.Bag;
import it.alten.game.model.dto.BagDto;
import it.alten.game.repository.BagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BagServiceImpl implements BagService{

    private final BagRepository bagRepository;

    @Autowired
    public BagServiceImpl(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    @Override
    public Bag save(BagDto bagDto) {
        ModelMapper modelMapper = new ModelMapper();
        Bag bagSaved = modelMapper.map(bagDto,Bag.class);
        bagRepository.save(bagSaved);
        return bagSaved;
    }
}

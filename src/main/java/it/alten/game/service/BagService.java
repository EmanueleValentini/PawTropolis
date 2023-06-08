package it.alten.game.service;

import it.alten.game.model.dto.BagDto;
import org.springframework.stereotype.Service;

@Service
public interface BagService {

    void save (BagDto bagDto);

    BagDto findById (int id);
}

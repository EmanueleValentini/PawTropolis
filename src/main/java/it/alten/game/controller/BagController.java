package it.alten.game.controller;

import it.alten.game.model.dto.BagDto;
import it.alten.game.service.BagService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class BagController {

    private final BagService bagService;


    @Autowired
    public BagController(BagService bagService) {
        this.bagService = bagService;
    }

    public BagDto findById(int id) {

        return bagService.findById(id);
    }

}

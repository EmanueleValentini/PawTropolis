package it.alten.game.controller;

import it.alten.game.model.Bag;
import it.alten.game.model.ItemInBag;
import it.alten.game.service.BagService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Data
public class BagController {

    private final BagService bagService;


    @Autowired
    public BagController(BagService bagService) {
        this.bagService = bagService;
    }

    public Bag findById(int id) {

        return bagService.findById(id);
    }


}

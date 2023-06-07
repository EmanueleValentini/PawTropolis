package it.alten.animal.controller;

import it.alten.animal.model.Eagle;
import it.alten.animal.service.EagleService;
import it.alten.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EagleController {

    private  final EagleService eagleService;
    @Autowired
    public EagleController(EagleService eagleService) {
        this.eagleService = eagleService;
    }

    public List<Eagle> findByRoom(Room room) {

        return eagleService.findByRoom(room);
    }
}

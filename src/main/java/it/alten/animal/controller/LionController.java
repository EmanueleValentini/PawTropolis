package it.alten.animal.controller;

import it.alten.animal.model.Lion;
import it.alten.animal.service.LionService;
import it.alten.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LionController {
    private  final LionService lionService;

    @Autowired
    public LionController(LionService lionService) {
        this.lionService = lionService;
    }

    public List<Lion> findByRoom(Room room) {
        return lionService.findByRoom(room);
    }
}

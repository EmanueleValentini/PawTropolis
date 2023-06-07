package it.alten.animal.controller;

import it.alten.animal.model.Tiger;
import it.alten.animal.service.TigerService;
import it.alten.game.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TigerController {

   private final TigerService tigerService;

   @Autowired
    public TigerController(TigerService tigerService) {
        this.tigerService = tigerService;
    }

    public List<Tiger> findByRoom(Room room) {

       return tigerService.findByRoom(room);
    }
}

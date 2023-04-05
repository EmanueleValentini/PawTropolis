package it.alten.game.controller;

import it.alten.game.model.Item;
import it.alten.game.model.Room;

public class RoomController {

    // TODO: navigation between room
    private Room room;

    public RoomController() {

        room = createMap();
    }


    private static Room createMap(){

        Room entrance = new Room("DAJE ROMA DAJE");
        Room boss = new Room("La stanza del Boss");
        Room healingFountain = new Room("Viale Marconi");
        Room thiefCity = new Room("Napoli");
        Room terminiStation = new Room("Drug Ville");
        Room lastRoom = new Room("Secco refresh");
        entrance.addItemToRoom(new Item("excalibur",
                "la famosa spada nella roccia che re Artù dovette estrarre per diventare re di Camelot, per poi sposare Ginevra e farsela rubare da Lancillotto",
                1));


    }
}

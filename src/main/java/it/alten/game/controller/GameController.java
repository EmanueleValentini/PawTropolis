package it.alten.game.controller;

import it.alten.animal.model.Animal;
import it.alten.game.model.Bag;
import it.alten.game.model.Item;
import it.alten.game.model.Player;
import it.alten.game.model.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    Map<Integer, Animal> animalMap = new HashMap<>();
    Player player = new Player("paolo",3);
    List<Item> roomItems = new ArrayList<>();
    List<Item> gameItems = new ArrayList<>();
    List<Item> playerItems = new ArrayList<>();
    Bag bag = new Bag();
    List<Room> rooms = new ArrayList<>();


    //  TODO: implementation of all controllers



}

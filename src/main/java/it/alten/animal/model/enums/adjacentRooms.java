package it.alten.animal.model.enums;

import java.util.Arrays;

public enum adjacentRooms {
    NORTH("north"),
    WEST("west"),
    EST("est"),
    SOUTH("south"),
    NOT_VALID("not valid");

    private final String name;

    adjacentRooms(String name) {
        this.name = name;
    }

   
}

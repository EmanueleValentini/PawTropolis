package it.alten.game.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public enum Direction {
    NORTH("north"),
    WEST("west"),
    EAST("east"),
    SOUTH("south"),
    NOT_VALID("not valid");

    private final String name;

    public static Direction getOppositeDirection(Direction direction) {
        switch (direction){
            case NORTH -> {
                return SOUTH;
            } case SOUTH -> {
                return NORTH;
            } case EAST -> {
                return WEST;
            } case WEST -> {
                return EAST;
            } default -> {
                return NOT_VALID;
            }
        }
    }

    public static Direction of (String s) {
        List<Direction> directions = new ArrayList<>();
        directions.add(NORTH);
        directions.add(EAST);
        directions.add(WEST);
        directions.add(SOUTH);
        directions.add(NOT_VALID);
        Direction askedDirection = NOT_VALID;
        for (Direction direction: directions) {
            if (s.equalsIgnoreCase(direction.getName())) {
                askedDirection = direction;
            }
        }
        return askedDirection;
    }
}

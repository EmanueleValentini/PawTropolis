package it.alten.game.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@Component

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
}

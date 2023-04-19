package it.alten.game.model.enums;


public enum Direction {
    NORTH("north"),
    WEST("west"),
    EAST("east"),
    SOUTH("south"),
    NOT_VALID("not valid");

    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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

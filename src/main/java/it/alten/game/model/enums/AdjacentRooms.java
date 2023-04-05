package it.alten.game.model.enums;


public enum AdjacentRooms {
    NORTH("north"),
    WEST("west"),
    EAST("east"),
    SOUTH("south"),
    NOT_VALID("not valid");

    private final String name;

    AdjacentRooms(String name) {

        this.name = name;
    }

    public static AdjacentRooms availableDirections(String s) {
        for (AdjacentRooms d : values()) {
            if (s.equalsIgnoreCase(d.getName())) {
                return d;
            }
        }
        return NOT_VALID;
    }

    public String getName() {
        return name;
    }
}

package it.alten.animal.model.enums;


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

    public static adjacentRooms availableDirections(String s) {
        for (adjacentRooms d : values()) {
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

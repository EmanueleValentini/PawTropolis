package it.alten.game.model;

public class Player {
    private String name;
    private int lifePoints;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return lifePoints;
    }

    public void setPoints(int points) {
        this.lifePoints = points;
    }


}

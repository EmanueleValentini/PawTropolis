package it.alten.game.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Door {

    private boolean isClosed;

    private Item itemToOpen;

    public Door(Item itemToOpen) {
        this.itemToOpen = itemToOpen;
        isClosed = true;
    }

    public Door(){
        isClosed = false;
    }
}

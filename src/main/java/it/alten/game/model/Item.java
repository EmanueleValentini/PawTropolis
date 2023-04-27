package it.alten.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Component
public class Item {
    private String name;
    private String description;
    private int requestedSlots;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return requestedSlots == item.requestedSlots && Objects.equals(name, item.name) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, requestedSlots);
    }

    @Override
    public String toString() {
        return name;
    }
}

package it.alten;

import it.alten.model.Animal;
import it.alten.model.Eagle;
import it.alten.model.Lion;
import it.alten.model.Tiger;

import java.util.Collections;
import java.util.List;

public class Zoo {

    private List<Lion> lions;

    private List<Tiger> tigers;

    private List<Eagle> eagles;

    public Zoo(List<Lion> lions, List<Tiger> tigers, List<Eagle> eagles) {
        this.lions = lions;
        this.tigers = tigers;
        this.eagles = eagles;
    }

    public List<Lion> getLions() {
        return lions;
    }

    public void setLions(List<Lion> lions) {
        this.lions = lions;
    }

    public List<Tiger> getTigers() {
        return tigers;
    }

    public void setTigers(List<Tiger> tigers) {
        this.tigers = tigers;
    }

    public List<Eagle> getEagles() {
        return eagles;
    }

    public void setEagles(List<Eagle> eagles) {
        this.eagles = eagles;
    }

    public void addAnimal(Animal animal){
        if (animal instanceof Tiger){
            tigers.add((Tiger) animal);
        } else if (animal instanceof Lion) {
            lions.add((Lion) animal);
        } else {
            eagles.add((Eagle) animal);
        }
    }

    public Lion highest(List<Lion> lions){
        if(lions.size()==0){
            return null;
        }

        Lion tallestLion = lions.get(0);

        for (Lion lion:lions) {
            if(lion.getHeight() > tallestLion.getHeight()){
                tallestLion = lion;
            }
        }
        return tallestLion;
    }

    public Lion shortest(List<Lion> lions){
        if(lions.size()==0){
            return null;
        }

        Lion shortestLion = lions.get(0);

        for (Lion lion:lions) {
            if(lion.getHeight() > shortestLion.getHeight()){
                shortestLion = lion;
            }
        }
        return shortestLion;
    }
}

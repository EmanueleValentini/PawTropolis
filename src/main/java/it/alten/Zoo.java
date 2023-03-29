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


    //Lion
    public Lion getHighestLion(List<Lion> lions){
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

    public Lion getShortestLion(List<Lion> lions){
        if(lions.size()==0){
            return null;
        }

        Lion shortestLion = lions.get(0);

        for (Lion lion:lions) {
            if(lion.getHeight() < shortestLion.getHeight()){
                shortestLion = lion;
            }
        }
        return shortestLion;
    }

    public Lion getHeavierLion(List<Lion> lions){
        if(lions.size()==0){
            return null;
        }

        Lion heaviestLion = lions.get(0);

        for (Lion lion:lions) {
            if(lion.getHeight() > heaviestLion.getHeight()){
                heaviestLion = lion;
            }
        }
        return heaviestLion;
    }

    public Lion getLighterLion(List<Lion> lions){
        if(lions.size()==0){
            return null;
        }

        Lion lightestLion = lions.get(0);

        for (Lion lion:lions) {
            if(lion.getHeight() < lightestLion.getHeight()){
                lightestLion = lion;
            }
        }
        return lightestLion;
    }

    //Tiger
    public Tiger getHighestTiger(List<Tiger> tigers){
        if(tigers.size()==0){
            return null;
        }

        Tiger tallestTiger = tigers.get(0);

        for (Tiger tiger:tigers) {
            if(tiger.getHeight() > tallestTiger.getHeight()){
                tallestTiger = tiger;
            }
        }
        return tallestTiger;
    }

    public Tiger getShortestTiger(List<Tiger> tigers){
        if(tigers.size()==0){
            return null;
        }

        Tiger shortestTiger = tigers.get(0);

        for (Tiger tiger:tigers) {
            if(tiger.getHeight() < shortestTiger.getHeight()){
                shortestTiger = tiger;
            }
        }
        return shortestTiger;
    }

    public Tiger getHeavierTiger(List<Tiger> tigers){
        if(tigers.size()==0){
            return null;
        }

        Tiger heaviestTiger = tigers.get(0);

        for (Tiger tiger:tigers) {
            if(tiger.getHeight() > heaviestTiger.getHeight()){
                heaviestTiger = tiger;
            }
        }
        return heaviestTiger;
    }

    public Tiger getLighterTiger(List<Tiger> tigers){
        if(tigers.size()==0){
            return null;
        }

        Tiger lightestTiger = tigers.get(0);

        for (Tiger tiger:tigers) {
            if(tiger.getHeight() < lightestTiger.getHeight()){
                lightestTiger = tiger;
            }
        }
        return lightestTiger;
    }

    //Eagle
    public Eagle getHighestEagle(List<Eagle> eagles){
        if(eagles.size()==0){
            return null;
        }

        Eagle tallestEagle = eagles.get(0);

        for (Eagle eagle:eagles) {
            if(eagle.getHeight() > tallestEagle.getHeight()){
                tallestEagle = eagle;
            }
        }
        return tallestEagle;
    }

    public Eagle getShortestEagle(List<Eagle> tigers){
        if(eagles.size()==0){
            return null;
        }

        Eagle shortestEagle = eagles.get(0);

        for (Eagle eagle:eagles) {
            if(eagle.getHeight() < shortestEagle.getHeight()){
                shortestEagle = eagle;
            }
        }
        return shortestEagle;
    }

    public Eagle getHeavierEagle(List<Eagle> tigers){
        if(eagles.size()==0){
            return null;
        }

        Eagle heaviestEagle = eagles.get(0);

        for (Eagle eagle:eagles) {
            if(eagle.getHeight() > heaviestEagle.getHeight()){
                heaviestEagle = eagle;
            }
        }
        return heaviestEagle;
    }

    public Eagle getLighterEagle(List<Eagle> tigers){
        if(eagles.size()==0){
            return null;
        }

        Eagle lightestEagle = eagles.get(0);

        for (Eagle eagle:eagles) {
            if(eagle.getHeight() < lightestEagle.getHeight()){
                lightestEagle = eagle;
            }
        }
        return lightestEagle;
    }
}

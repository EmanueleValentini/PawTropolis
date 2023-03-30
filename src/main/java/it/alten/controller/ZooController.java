package it.alten.controller;

import it.alten.model.*;

import java.util.ArrayList;
import java.util.List;

public class ZooController {

    private List<Lion> lions;

    private List<Tiger> tigers;

    private List<Eagle> eagles;

    public ZooController() {
        this.lions = new ArrayList<>();
        this.tigers = new ArrayList<>();
        this.eagles = new ArrayList<>();
    }

    public List<Lion> getLions() {
        return lions;
    }

    public void setLions(List<Lion> lions) {this.lions = lions;}

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
        } else if (animal instanceof Eagle){
            eagles.add((Eagle) animal);
        } else {
            System.out.println("Species not recognized");
        }
    }

    public List<AnimalWithTail> getAllAnimalsWithTail(){
        List<AnimalWithTail> animalsWithTail = new ArrayList<>();
        animalsWithTail.addAll(lions);
        animalsWithTail.addAll(tigers);
        return animalsWithTail;
    }

    public List<AnimalWithWings> getAllAnimalsWithWings(){
        List<AnimalWithWings> animasWithWings = new ArrayList<>();
        animasWithWings.addAll(eagles);
        return animasWithWings;
    }

    public AnimalWithTail getAnimalWithLongestTail() {
        List<AnimalWithTail> animalsWithTail = getAllAnimalsWithTail();

        if (animalsWithTail.size()==0) {
            return null;
        }

        AnimalWithTail animalWithLongestTail = animalsWithTail.get(0);

        for (AnimalWithTail currentAnimal : animalsWithTail) {
            if (currentAnimal.getTailLength() > animalWithLongestTail.getTailLength()) {
                animalWithLongestTail = currentAnimal;
            }
        }
        return animalWithLongestTail;
    }

    public AnimalWithWings getAnimalWithWidestWingspan() {
        List<AnimalWithWings> animalsWithWings = getAllAnimalsWithWings();
        if (animalsWithWings.size()==0) {
            return null;
        }

        AnimalWithWings animalWithWidestWingspan = animalsWithWings.get(0);

        for (AnimalWithWings animalWithWings : animalsWithWings) {
            if (animalWithWings.getWingspan() > animalWithWidestWingspan.getWingspan()) {
                animalWithWidestWingspan = animalWithWings;
            }
        }
        return animalWithWidestWingspan;
    }


    //Lion
    public Lion getHighestLion(){
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

    public Lion getShortestLion(){
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

    public Lion getHeaviestLion(){
        if(lions.size()==0){
            return null;
        }

        Lion heaviestLion = lions.get(0);

        for (Lion lion:lions) {
            if(lion.getWeight() > heaviestLion.getWeight()){
                heaviestLion = lion;
            }
        }
        return heaviestLion;
    }

    public Lion getLightestLion(){
        if(lions.size()==0){
            return null;
        }

        Lion lightestLion = lions.get(0);

        for (Lion lion:lions) {
            if(lion.getWeight() < lightestLion.getWeight()){
                lightestLion = lion;
            }
        }
        return lightestLion;
    }

    //Tiger
    public Tiger getHighestTiger(){
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

    public Tiger getShortestTiger(){
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

    public Tiger getHeaviestTiger(){
        if(tigers.size()==0){
            return null;
        }

        Tiger heaviestTiger = tigers.get(0);

        for (Tiger tiger:tigers) {
            if(tiger.getWeight() > heaviestTiger.getWeight()){
                heaviestTiger = tiger;
            }
        }
        return heaviestTiger;
    }

    public Tiger getLightestTiger(){
        if(tigers.size()==0){
            return null;
        }

        Tiger lightestTiger = tigers.get(0);

        for (Tiger tiger:tigers) {
            if(tiger.getWeight() < lightestTiger.getWeight()){
                lightestTiger = tiger;
            }
        }
        return lightestTiger;
    }

    //Eagle
    public Eagle getHighestEagle(){
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

    public Eagle getShortestEagle(){
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

    public Eagle getHeaviestEagle(){
        if(eagles.size()==0){
            return null;
        }

        Eagle heaviestEagle = eagles.get(0);

        for (Eagle eagle:eagles) {
            if(eagle.getWeight() > heaviestEagle.getWeight()){
                heaviestEagle = eagle;
            }
        }
        return heaviestEagle;
    }

    public Eagle getLightestEagle(){
        if(eagles.size()==0){
            return null;
        }

        Eagle lightestEagle = eagles.get(0);

        for (Eagle eagle:eagles) {
            if(eagle.getWeight() < lightestEagle.getWeight()){
                lightestEagle = eagle;
            }
        }
        return lightestEagle;
    }
}

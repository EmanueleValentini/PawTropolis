package it.alten;

import it.alten.controller.ZooController;
import it.alten.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        testZoo();
    }
    private static void testZoo() {
        ZooController zoo = new ZooController();

        Lion lion1 = new Lion("Simba", "mango", 3, LocalDate.now(), 10.9, 1.1, 0.5);
        Lion lion2 = new Lion("Kimba", "caffè Kimbo", 5, LocalDate.now(), 13.0, 0.7, 0.9);
        Lion lion3 = new Lion("Cane Fifone", "Torta di Marilù", 10, LocalDate.now(), 8.0, 1.2, 6.21);

        zoo.addAnimal(lion1);
        zoo.addAnimal(lion2);
        zoo.addAnimal(lion3);

        Tiger tiger1 = new Tiger("Man", "pizza", 30, LocalDate.now(), 80.0, 1.8, 0.3);
        Tiger tiger2 = new Tiger("Tigro", "miele", 8, LocalDate.now(), 20.0, 1.0, 0.7);
        Tiger tiger3 = new Tiger("Asdrubale", "carbonara", 27, LocalDate.now(), 70.0, 1.7, 1.0);

        zoo.addAnimal(tiger1);
        zoo.addAnimal(tiger2);
        zoo.addAnimal(tiger3);

        Eagle eagle1 = new Eagle("Piccione", "pane", 1, LocalDate.now(), 1.0, 0.2, 0.3);
        Eagle eagle2 = new Eagle("Zazu", "marmellata", 9, LocalDate.now(), 2.0, 0.3, 0.5);
        Eagle eagle3 = new Eagle("Daily Eagle", "hot dog", 50, LocalDate.now(), 30.0, 1.0, 2.0);

        zoo.addAnimal(eagle1);
        zoo.addAnimal(eagle2);
        zoo.addAnimal(eagle3);

        AnimalWithTail animalWithLongestTail = zoo.getAnimalWithLongestTail();
        System.out.println("Animal with longest tail: " + animalWithLongestTail.getName());

        AnimalWithWings animalWithWidestWingspan = zoo.getAnimalWithWidestWingspan();
        System.out.println("Eagle with widest wingspan: " + animalWithWidestWingspan.getName());

        Tiger tallestTiger = zoo.getTallestTiger();
        System.out.println("Tallest tiger: " + tallestTiger.getName());

        Tiger shortestTiger = zoo.getShortestTiger();
        System.out.println("Shortest tiger: " + shortestTiger.getName());

        Lion tallestLion = zoo.getTallestLion();
        System.out.println("Tallest lion: " + tallestLion.getName());

        Lion shortestLion = zoo.getShortestLion();
        System.out.println("Shortest lion: " + shortestLion.getName());

        Eagle tallestEagle = zoo.getTallestEagle();
        System.out.println("Tallest eagle: " + tallestEagle.getName());

        Eagle shortestEagle = zoo.getShortestEagle();
        System.out.println("Shortest eagle: " + shortestEagle.getName());

        Tiger heaviestTiger = zoo.getHeaviestTiger();
        System.out.println("Heaviest tiger: " + heaviestTiger.getName());

        Tiger lightestTiger = zoo.getLightestTiger();
        System.out.println("Lightest tiger: " + lightestTiger.getName());

        Lion heaviestLion = zoo.getHeaviestLion();
        System.out.println("Heaviest lion: " + heaviestLion.getName());

        Lion lightestLion = zoo.getLightestLion();
        System.out.println("Lightest lion: " + lightestLion.getName());

        Eagle heaviestEagle = zoo.getHeaviestEagle();
        System.out.println("Heaviest eagle: " + heaviestEagle.getName());

        Eagle lightestEagle = zoo.getLightestEagle();
        System.out.println("Lightest eagle: " + lightestEagle.getName());
    }
}
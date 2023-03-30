import it.alten.controller.Zoo;
import it.alten.model.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestZoo {

    Zoo zoo = new Zoo();

    Lion lion1 = new Lion("Simba", "mango", 3, LocalDate.now(), 10.9, 1.1, 0.5);
    Lion lion2 = new Lion("Kimba", "caffè Kimbo", 5, LocalDate.now(), 13.0, 0.7, 0.9);
    Lion lion3 = new Lion("Cane Fifone", "Torta di Marilù", 10, LocalDate.now(), 8.0, 1.1, 6.21);
    Tiger tiger1 = new Tiger("Man", "pizza", 30, LocalDate.now(), 80.0, 1.8, 0.3);
    Tiger tiger2 = new Tiger("Tigro", "miele", 8, LocalDate.now(), 20.0, 1.0, 0.7);
    Tiger tiger3 = new Tiger("Asdrubale", "carbonara", 27, LocalDate.now(), 70.0, 1.7, 1.0);
    Eagle eagle1 = new Eagle("Piccione", "pane", 1, LocalDate.now(), 1.0, 0.2, 0.3);
    Eagle eagle2 = new Eagle("Zazu", "marmellata", 9, LocalDate.now(), 2.0, 0.3, 0.5);
    Eagle eagle3 = new Eagle("Daily Eagle", "hot dog", 50, LocalDate.now(), 30.0, 1.0, 2.0);
    @Test
    public void testHeaviestLion(){
        zoo.addAnimal(lion1);
        zoo.addAnimal(lion2);
        zoo.addAnimal(lion3);
        Lion heaviestLion = zoo.getHeaviestLion();
        assertEquals ("Kimba",heaviestLion.getName());
    }

    @Test
    public void testHeaviesTiger(){
        zoo.addAnimal(tiger1);
        zoo.addAnimal(tiger2);
        zoo.addAnimal(tiger3);
        Tiger heaviestTiger = zoo.getHeaviestTiger();
        assertEquals("Man",heaviestTiger.getName());
    }

    @Test
    public void testHeaviesEagle(){
        zoo.addAnimal(eagle1);
        zoo.addAnimal(eagle2);
        zoo.addAnimal(eagle3);
        Eagle heaviestEagle = zoo.getHeaviestEagle();
        assertEquals("Daily Eagle",heaviestEagle.getName());
    }

    @Test
    public void testLightestLion(){
        zoo.addAnimal(lion1);
        zoo.addAnimal(lion2);
        zoo.addAnimal(lion3);
        Lion lightestLion = zoo.getLightestLion();
        assertEquals ("Cane Fifone",lightestLion.getName());
    }

    @Test
    public void testLightestTiger(){
        zoo.addAnimal(tiger1);
        zoo.addAnimal(tiger2);
        zoo.addAnimal(tiger3);
        Tiger lightestTiger = zoo.getLightestTiger();
        assertEquals("Tigro",lightestTiger.getName());
    }

    @Test
    public void testLightestEagle(){
        zoo.addAnimal(eagle1);
        zoo.addAnimal(eagle2);
        zoo.addAnimal(eagle3);
        Eagle lightestEagle = zoo.getLightestEagle();
        assertEquals("Piccione",lightestEagle.getName());
    }

    @Test
    public void testHighestLion(){
        zoo.addAnimal(lion1);
        zoo.addAnimal(lion2);
        zoo.addAnimal(lion3);
        Lion highestLion = zoo.getHighestLion();
        assertEquals ("Simba",highestLion.getName());
    }

    @Test
    public void testHighestTiger(){
        zoo.addAnimal(tiger1);
        zoo.addAnimal(tiger2);
        zoo.addAnimal(tiger3);
        Tiger highestTiger = zoo.getHighestTiger();
        assertEquals("Man",highestTiger.getName());
    }

    @Test
    public void testHighestEagle(){
        zoo.addAnimal(eagle1);
        zoo.addAnimal(eagle2);
        zoo.addAnimal(eagle3);
        Eagle highestEagle = zoo.getHighestEagle();
        assertEquals("Daily Eagle",highestEagle.getName());
    }

    @Test
    public void testShortestLion(){
        zoo.addAnimal(lion1);
        zoo.addAnimal(lion2);
        zoo.addAnimal(lion3);
        Lion shortestLion = zoo.getShortestLion();
        assertEquals ("Kimba",shortestLion.getName());
    }

    @Test
    public void testShortestTiger(){
        zoo.addAnimal(tiger1);
        zoo.addAnimal(tiger2);
        zoo.addAnimal(tiger3);
        Tiger shortestTiger = zoo.getShortestTiger();
        assertEquals("Tigro",shortestTiger.getName());
    }

    @Test
    public void testShortestEagle(){
        zoo.addAnimal(eagle1);
        zoo.addAnimal(eagle2);
        zoo.addAnimal(eagle3);
        Eagle shortestEagle = zoo.getShortestEagle();
        assertEquals("Piccione",shortestEagle.getName());
    }

    @Test
    public void testLongestTail(){
        zoo.addAnimal(lion1);
        zoo.addAnimal(lion2);
        zoo.addAnimal(lion3);
        zoo.addAnimal(tiger1);
        zoo.addAnimal(tiger2);
        zoo.addAnimal(tiger3);
        AnimalWithTail animalWithLongestTail = zoo.getAnimalWithLongestTail();
        assertEquals("Cane Fifone",animalWithLongestTail.getName());
    }

    @Test
    public void testWidestWingspan(){
        zoo.addAnimal(eagle1);
        zoo.addAnimal(eagle2);
        zoo.addAnimal(eagle3);
        AnimalWithWings animalwithWidestWingspan = zoo.getAnimalWithWidestWingspan();
        assertEquals("Daily Eagle",animalwithWidestWingspan.getName());
    }
}

import it.alten.controller.ZooController;
import it.alten.model.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;


public class TestZoo extends TestCase {
    ZooController zoo;

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        zoo = new ZooController();
        Lion lion1 = new Lion("Simba", "mango", 3, LocalDate.now(), 10.9, 1.1, 0.5);
        Lion lion2 = new Lion("Kimba", "caffè Kimbo", 5, LocalDate.now(), 13.0, 0.7, 0.9);
        Lion lion3 = new Lion("Cane Fifone", "Torta di Marilù", 10, LocalDate.now(), 8.0, 1.1, 6.21);
        Tiger tiger1 = new Tiger("Man", "pizza", 30, LocalDate.now(), 80.0, 1.8, 0.3);
        Tiger tiger2 = new Tiger("Tigro", "miele", 8, LocalDate.now(), 20.0, 1.0, 0.7);
        Tiger tiger3 = new Tiger("Asdrubale", "carbonara", 27, LocalDate.now(), 70.0, 1.7, 1.0);
        Eagle eagle1 = new Eagle("Piccione", "pane", 1, LocalDate.now(), 1.0, 0.2, 0.3);
        Eagle eagle2 = new Eagle("Zazu", "marmellata", 9, LocalDate.now(), 2.0, 0.3, 0.5);
        Eagle eagle3 = new Eagle("Daily Eagle", "hot dog", 50, LocalDate.now(), 30.0, 1.0, 2.0);
        zoo.addAnimal(lion1);
        zoo.addAnimal(lion2);
        zoo.addAnimal(lion3);
        zoo.addAnimal(tiger1);
        zoo.addAnimal(tiger2);
        zoo.addAnimal(tiger3);
        zoo.addAnimal(eagle1);
        zoo.addAnimal(eagle2);
        zoo.addAnimal(eagle3);
    }

    @Test
    public void testHeaviestLion(){
        Lion heaviestLion = zoo.getHeaviestLion();
        assertEquals ("Kimba",heaviestLion.getName());
    }

    @Test
    public void testHeaviesTiger(){
        Tiger heaviestTiger = zoo.getHeaviestTiger();
        assertEquals("Man",heaviestTiger.getName());
    }

    @Test
    public void testHeaviesEagle(){
        Eagle heaviestEagle = zoo.getHeaviestEagle();
        assertEquals("Daily Eagle",heaviestEagle.getName());
    }

    @Test
    public void testLightestLion(){
        Lion lightestLion = zoo.getLightestLion();
        assertEquals ("Cane Fifone",lightestLion.getName());
    }

    @Test
    public void testLightestTiger(){
        Tiger lightestTiger = zoo.getLightestTiger();
        assertEquals("Tigro",lightestTiger.getName());
    }

    @Test
    public void testLightestEagle(){
        Eagle lightestEagle = zoo.getLightestEagle();
        assertEquals("Piccione",lightestEagle.getName());
    }

    @Test
    public void testTallestLion(){
        Lion tallestLion = zoo.getTallestLion();
        assertEquals ("Simba",tallestLion.getName());
    }

    @Test
    public void testTallestTiger(){
        Tiger tallestTiger = zoo.getTallestTiger();
        assertEquals("Man",tallestTiger.getName());
    }

    @Test
    public void testTallestEagle(){
        Eagle tallestEagle = zoo.getTallestEagle();
        assertEquals("Daily Eagle",tallestEagle.getName());
    }

    @Test
    public void testShortestLion(){
        Lion shortestLion = zoo.getShortestLion();
        assertEquals ("Kimba",shortestLion.getName());
    }

    @Test
    public void testShortestTiger(){
        Tiger shortestTiger = zoo.getShortestTiger();
        assertEquals("Tigro",shortestTiger.getName());
    }

    @Test
    public void testShortestEagle(){
        Eagle shortestEagle = zoo.getShortestEagle();
        assertEquals("Piccione",shortestEagle.getName());
    }

    @Test
    public void testLongestTail(){
        AnimalWithTail animalWithLongestTail = zoo.getAnimalWithLongestTail();
        assertEquals("Cane Fifone",animalWithLongestTail.getName());
    }

    @Test
    public void testWidestWingspan(){
        AnimalWithWings animalwithWidestWingspan = zoo.getAnimalWithWidestWingspan();
        assertEquals("Daily Eagle",animalwithWidestWingspan.getName());
    }
}

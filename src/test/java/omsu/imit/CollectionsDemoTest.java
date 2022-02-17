package omsu.imit;

import static omsu.imit.CollectionsDemo.countLines;
import static omsu.imit.CollectionsDemo.getNamesakes;
import static omsu.imit.CollectionsDemo.copyWithout;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import java.util.Collections;

/**
 * Unit test for simple CollectionsDemo.
 */
public class CollectionsDemoTest
{
    /**
     * Rigorous Test :-)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCountEmptyLines(){
        List<String> lines = new ArrayList<>();
        lines = Collections.EMPTY_LIST;
        countLines(lines, 'a');

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountNullLines(){
        List<String> lines = new ArrayList<>();
        lines = null;
        countLines(lines, 'a');
    }

    @Test
    public void testCountLinesNotZero(){
        List<String> lines = new ArrayList<String>();
        Collections.addAll(lines, "apple", "orange",
                            "pineapple", "abcde", "acid");
        Assert.assertEquals(3, countLines(lines, 'a'));

    }

    @Test
    public void testCountLinesZero(){
        List<String> lines = new ArrayList<String>();
        Collections.addAll(lines, "bbq", "butterfly", "coffee", "juice");
        Assert.assertEquals(0, countLines(lines, 'a'));
    }

    @Test
    public void testCountLinesWithNullElem(){
        List<String> lines = new ArrayList<String>();
        Collections.addAll(lines, "bbq", null, "coffee", "juice");
        Assert.assertEquals(0, countLines(lines, 'a'));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetNamesakesWithEmptyPersons(){
        Human p0 = new Human();
        getNamesakes(Collections.EMPTY_LIST, p0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNamesakesWithNullPersons(){
        Human p0 = new Human();
        getNamesakes(null, p0);
    }


    @Test
    public void testGetNamesakes(){
        List<Human> persons = new ArrayList<>();
        List<Human> personsRes = new ArrayList<>();
        Human p0 = new Human();
        Human p1 = new Human();
        Human p2 = new Human();
        p2.setSurname("Сидорова");
        Human p3 = new Human();
        p3.setSurname("Алексеева");
        Human p4 = new Human();
        p4.setName("Анна");
        Collections.addAll(persons, p1, p2, p3, p4);
        Collections.addAll(personsRes, p1, p4);
        Assert.assertEquals(personsRes, getNamesakes(persons, p0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNamesakesWithNullPerson(){
        List<Human> persons = new ArrayList<>();
      //  List<Human> personsRes = new ArrayList<>();
        Human p1 = new Human();
        Human p2 = new Human();
        p2.setSurname("Сидорова");
        Human p3 = new Human();
        p3.setSurname("Алексеева");
        Human p4 = new Human();
        p4.setName("Анна");
        Collections.addAll(persons, p1, p2, p3, p4);
       // Collections.addAll(personsRes, p1, p4);
        getNamesakes(persons, null);
    }

    @Test
    public void testGetNamesakesWithNullElem(){
        List<Human> persons = new ArrayList<>();
        List<Human> personsRes = new ArrayList<>();
        Human p0 = new Human();
        Human p1 = new Human();
        Human p2 = new Human();
        p2.setSurname("Сидорова");
        Human p4 = new Human();
        p4.setName("Анна");

        Collections.addAll(persons, p1, p2, null, p4);
        Collections.addAll(personsRes, p1, p4);
        Assert.assertEquals(personsRes, getNamesakes(persons, p0));
    }

    @Test
    public void testGetNoNamesakes(){
        List<Human> persons = new ArrayList<>();
        List<Human> personsRes = new ArrayList<>();
        Human p0 = new Human();
        p0.setSurname("Алексеева");
        Human p1 = new Human();
        Human p2 = new Human();
        Human p3 = new Human();
        Human p4 = new Human();
        Collections.addAll(persons, p1, p2, p3, p4);
        Assert.assertEquals(personsRes, getNamesakes(persons, p0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyWithoutNullPersons(){
        Human p0 = new Human();
        copyWithout(null, p0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyWithoutEmptyPersons(){
        Human p0 = new Human();
        copyWithout(Collections.EMPTY_LIST, p0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyWithoutNullPerson(){
        List<Human> persons = new ArrayList<>();
        Human p1 = new Human();
        Human p2 = new Human();
        Human p3 = new Human();
        Human p4 = new Human();
        Collections.addAll(persons, p1, p2, p3, p4);
        copyWithout(persons, null);
    }

    @Test
    public void testCopyWithout(){
        List<Human> persons = new ArrayList<>();
        List<Human> newPersons = new ArrayList<>();
        Human p1 = new Human();
        Human p2 = new Human();
        p2.setName("Анна");
        Human p3 = new Human();
        Human p4 = null;
        Human p0 = new Human();
        p0.setName("Анна");
        Collections.addAll(persons, p1, p2, p3, p4);
        Collections.addAll(newPersons, p1, p3, p4);
        Assert.assertEquals(newPersons, copyWithout(persons, p0));


    }





}

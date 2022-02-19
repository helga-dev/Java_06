package omsu.imit;

import static omsu.imit.CollectionsDemo.countLines;
import static omsu.imit.CollectionsDemo.getNamesakes;
import static omsu.imit.CollectionsDemo.copyWithout;
import static omsu.imit.CollectionsDemo.deleteIntersections;

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

    @Test(expected = NullPointerException.class)
    public void testDeleteIntersectionsNullList(){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        deleteIntersections(null, set);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteIntersectionsNullSet(){
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        list.add(mySet);
        deleteIntersections(list, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteIntersectionsEmptyList(){
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        deleteIntersections(list, set);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteIntersectionsEmptySet(){
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        list.add(mySet);
        Set<Integer> set = new HashSet<>();
        deleteIntersections(list, set);
        }

    @Test
    public void testDeleteIntersections(){
        List<Set<Integer>> list = new ArrayList<>();
        List<Set<Integer>> newList = new ArrayList<>();
        Set<Integer> mySet1 = new HashSet<>();
        Set<Integer> mySet2 = new HashSet<>();
        Collections.addAll(mySet1, 1, 2, 3, 4, 5);
        Collections.addAll(mySet2, 6, 7, 8, 9, 10);
        Collections.addAll(list, mySet1, mySet2);
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, 1, 3);
        newList.add(mySet2);
        Assert.assertEquals(newList, deleteIntersections(list, set));
    }





}

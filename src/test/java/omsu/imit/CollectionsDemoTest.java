package omsu.imit;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import java.util.Collections;

import static omsu.imit.CollectionsDemo.*;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple CollectionsDemo.
 */
public class CollectionsDemoTest {
    /**
     * Rigorous Test :-)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCountEmptyLines() {
        List<String> lines = new ArrayList<>();
        lines = Collections.EMPTY_LIST;
        countLines(lines, 'a');

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountNullLines() {
        List<String> lines = new ArrayList<>();
        lines = null;
        countLines(lines, 'a');
    }

    @Test
    public void testCountLinesNotZero() {
        List<String> lines = new ArrayList<String>();
        Collections.addAll(lines, "apple", "orange",
                "pineapple", "abcde", "acid");
        assertEquals(3, countLines(lines, 'a'));

    }

    @Test
    public void testCountLinesZero() {
        List<String> lines = new ArrayList<String>();
        Collections.addAll(lines, "bbq", "butterfly", "coffee", "juice");
        assertEquals(0, countLines(lines, 'a'));
    }

    @Test
    public void testCountLinesWithNullElem() {
        List<String> lines = new ArrayList<String>();
        Collections.addAll(lines, "bbq", null, "coffee", "juice");
        assertEquals(0, countLines(lines, 'a'));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetNamesakesWithEmptyPersons() {
        Human p0 = new Human();
        getNamesakes(Collections.EMPTY_LIST, p0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNamesakesWithNullPersons() {
        Human p0 = new Human();
        getNamesakes(null, p0);
    }


    @Test
    public void testGetNamesakes() {
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
        assertEquals(personsRes, getNamesakes(persons, p0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNamesakesWithNullPerson() {
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
    public void testGetNamesakesWithNullElem() {
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
        assertEquals(personsRes, getNamesakes(persons, p0));
    }

    @Test
    public void testGetNoNamesakes() {
        List<Human> persons = new ArrayList<>();
        List<Human> personsRes = new ArrayList<>();
        Human p0 = new Human();
        p0.setSurname("Алексеева");
        Human p1 = new Human();
        Human p2 = new Human();
        Human p3 = new Human();
        Human p4 = new Human();
        Collections.addAll(persons, p1, p2, p3, p4);
        assertEquals(personsRes, getNamesakes(persons, p0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyWithoutNullPersons() {
        Human p0 = new Human();
        copyWithout(null, p0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyWithoutEmptyPersons() {
        Human p0 = new Human();
        copyWithout(Collections.EMPTY_LIST, p0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCopyWithoutNullPerson() {
        List<Human> persons = new ArrayList<>();
        Human p1 = new Human();
        Human p2 = new Human();
        Human p3 = new Human();
        Human p4 = new Human();
        Collections.addAll(persons, p1, p2, p3, p4);
        copyWithout(persons, null);
    }

    @Test
    public void testCopyWithout() {
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
        assertEquals(newPersons, copyWithout(persons, p0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteIntersectionsNullList() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        deleteIntersections(null, set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteIntersectionsNullSet() {
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        list.add(mySet);
        deleteIntersections(list, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteIntersectionsEmptyList() {
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        deleteIntersections(list, set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteIntersectionsEmptySet() {
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        list.add(mySet);
        Set<Integer> set = new HashSet<>();
        deleteIntersections(list, set);
    }

    @Test
    public void testDeleteIntersections() {
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
        assertEquals(newList, deleteIntersections(list, set));
    }

    @Test
    public void testDeleteIntersectionsEmptyListResult() {
        List<Set<Integer>> list = new ArrayList<>();
        List<Set<Integer>> newList = new ArrayList<>();
        Set<Integer> mySet1 = new HashSet<>();
        Set<Integer> mySet2 = new HashSet<>();
        Collections.addAll(mySet1, 1, 2, 4, 5);
        Collections.addAll(mySet2, 6, 7, 3, 9, 10);
        Collections.addAll(list, mySet1, mySet2);
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, 1, 3);
        assertEquals(newList, deleteIntersections(list, set));
    }


    @Test
    public void testGetMaxAge() {
        List<Human> list = new ArrayList<>();
        Collections.addAll(list,
                new Human("asd", "eeee", "bvndm", 56),
                new Student(),
                null,
                new Human("c", "a", "b", 35),
                new Student("rrr", "rrr", "rrr", 56, "hdwjh")
        );
        Set<Human> expected = new HashSet<>();
        Collections.addAll(expected,
                new Human("asd", "eeee", "bvndm", 56),
                new Student("rrr", "rrr", "rrr", 56, "hdwjh")
        );
        assertEquals(expected, getMaxAgeSet(list));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMaxAgeNullList() {
        getMaxAgeSet(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMaxAgeEmptyList() {
        List<Human> list = new ArrayList<>();
        getMaxAgeSet(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetHumanByNullKeySet() {
        Map<Integer, Human> humanMap = new HashMap<>();
        Human h1 = new Human("ab", "cksl", "ndj", 40);
        Human h2 = new Human("fdjkl", "dskl", "dsjkl", 20);
        humanMap.put(12, h1);
        humanMap.put(24, h2);
        getHumanByKey(humanMap, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetHumanByEmptyKeySet() {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Human> humanMap = new HashMap<>();
        Human h1 = new Human("ab", "cksl", "ndj", 40);
        Human h2 = new Human("fdjkl", "dskl", "dsjkl", 20);
        humanMap.put(12, h1);
        humanMap.put(24, h2);
        getHumanByKey(humanMap, set);
    }

 @Test(expected = IllegalArgumentException.class)
    public void testGetHumanByKeyNullMap() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        getHumanByKey(null, set);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetHumanByKeyEmptyMap() {
        Map<Integer, Human> humanMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        getHumanByKey(humanMap, set);
    }

    @Test
    public void testGetHumanByKey(){
        Map<Integer, Human> humanMap = new HashMap<>();
        Human h1 = new Human("ab", "cksl", "ndj", 40);
        Human h2 = new Human("fdjkl", "dskl", "dsjkl", 20);
        Human h3 = new Human("jdfk", "sss", "nnn", 200);
        Human h4 = new Human("hhh", "ttt", "kkk", 15);
        Human h5 = new Human("bb", "ww", "zz", 30);
        humanMap.put(1, h1);
        humanMap.put(5, h2);
//        humanMap.put(null, h3);
        humanMap.put(3, null);
        humanMap.put(12, h4);
        humanMap.put(4, h5);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(null);
        Set<Human> expected = new HashSet<>();
        expected.add(h1);
//        expected.add(h3);
        expected.add(h5);
        expected.add(null);
        assertEquals(expected, getHumanByKey(humanMap, set));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetAdultHumanKeysNullMap(){
        getAdultHumanKeys(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAdultHumanKeysEmptyMap(){
        Map<Integer, Human> map = new HashMap<>();
        getAdultHumanKeys(map);
    }

    @Test
    public void testGetAdultHumanKeys(){
        Map<Integer, Human> humanMap = new HashMap<>();
        Human h1 = new Human("ab", "cksl", "ndj", 40);
        Human h2 = new Human("fdjkl", "dskl", "dsjkl", 20);
        Human h3 = new Human("jdfk", "sss", "nnn", 200);
        Human h4 = new Human("hhh", "ttt", "kkk", 15);
        Human h5 = new Human("bb", "ww", "zz", 30);
        humanMap.put(1, h1);
        humanMap.put(5, h2);
        humanMap.put(null, h3);
        humanMap.put(3, null);
        humanMap.put(12, h4);
        humanMap.put(4, h5);
        List<Integer> expected = new ArrayList<>();
        expected.add(null);
        expected.add(1);
        expected.add(4);
        expected.add(5);

        assertEquals(expected, getAdultHumanKeys(humanMap));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCreateHumanAgeNullMap(){
        createHumanAgeMap(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHumanAgeEmptyMap(){
        Map<Integer, Human> map = new HashMap<>();
        createHumanAgeMap(map);
    }

    @Test
    public void testCreateHumanAgeMap(){
        Map<Integer, Human> humanMap = new HashMap<>();
        Human h1 = new Human("ab", "cksl", "ndj", 40);
        Human h2 = new Human("fdjkl", "dskl", "dsjkl", 20);
        Human h3 = new Human("jdfk", "sss", "nnn", 200);
        Human h4 = new Human("hhh", "ttt", "kkk", 15);
        Human h5 = new Human("bb", "ww", "zz", 30);
        humanMap.put(1, h1);
        humanMap.put(5, h2);
        humanMap.put(null, h3);
        humanMap.put(3, null);
        humanMap.put(12, h4);
        humanMap.put(4, h5);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, h1.getAge());
        expected.put(5, h2.getAge());
        expected.put(null, h3.getAge());
        expected.put(12, h4.getAge());
        expected.put(4, h5.getAge());

        assertEquals(expected, createHumanAgeMap(humanMap));

    }


    @Test(expected = IllegalArgumentException.class)
    public void testCreateSameAgeNullSet(){
        createSameAgeMap(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSameAgeEmptySet(){
        Set<Human> humanSet = new HashSet<>();
        createSameAgeMap(humanSet);
    }

    @Test
    public void testCreateSameAgeMap(){
        Human h1 = new Human("aa", "bb", "cc", 20);
        Human h2 = new Human("a", "b", "c", 20);
        Human h3 = new Human("aaa", "bbb", "ccc", 20);
        Human h4 = new Human("hhh", "ttt", "kkk", 15);
        Human h5 = new Human("bb", "ww", "zz", 30);
        Set<Human> humanSet = new HashSet<>();
        humanSet.add(h1);
        humanSet.add(h2);
        humanSet.add(h3);
        humanSet.add(h4);
        humanSet.add(h5);

        Map<Integer, List<Human>> expected = new HashMap<>();
        List<Human> list1 = new ArrayList<>();
        List<Human> list2 = new ArrayList<>();
        List<Human> list3 = new ArrayList<>();
        list1.add(h1);
        list1.add(h2);
        list1.add(h3);
        list2.add(h4);
        list3.add(h5);
        expected.put(20, list1);
        expected.put(15, list2);
        expected.put(30, list3);

        assertEquals(expected, createSameAgeMap(humanSet));


    }

}

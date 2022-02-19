package omsu.imit;

import java.util.*;

/**
 * Author
 * Created: 2022/02/10
 */
public class CollectionsDemo {
    public static void main(String[] args) {

    }

    public static int countLines(List<String> lines, char symbol) {
        int res = 0;
        if (lines == null) {
            throw new IllegalArgumentException("lines is null");
        }
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("lines is empty");
        }

        for (String line : lines) {
            if (line != null && line.indexOf(symbol) == 0) {
                res++;
            }
        }

        return res;
    }

    /**
     * 1 list == null
     * 2 list is empty
     * 3 list isnt empty count == 0
     * 4 list isnt empty count != 0
     * 5 list elem == null
     */

    public static List<Human> getNamesakes(List<Human> persons, Human person) {
        if (persons == null) {
            throw new IllegalArgumentException("list persons can't be null");
        }

        if (persons.isEmpty()) {
            throw new IllegalArgumentException("list persons can't be empty");
        }

        if (person == null) {
            throw new IllegalArgumentException("person can't be null");
        }

        List<Human> namesakes = new ArrayList<>();
        for (Human p : persons) {
            if (p != null && p.getSurname().equals(person.getSurname())) {
                namesakes.add(p);
            }
        }
        return namesakes;
    }

    public static List<Human> copyWithout(List<Human> persons, Human person) {
        if (persons == null) {
            throw new IllegalArgumentException("list persons can't be null");
        }

        if (persons.isEmpty()) {
            throw new IllegalArgumentException("list persons can't be empty");
        }

        if (person == null) {
            throw new IllegalArgumentException("person can't be null");
        }

        List<Human> newPersons = new ArrayList<>();
        for (Human p : persons) {
            if (!person.equals(p)) {
                newPersons.add(p);
            }
        }

        return newPersons;
    }


    //    самый главный тест не проходит
    public static List<Set<Integer>> deleteIntersections(List<Set<Integer>> list,
                                                         Set<Integer> set) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("list can't be empty");
        }
        if (list == null) {
            throw new NullPointerException("list can't be null");
        }
        if (set.isEmpty()) {
            throw new IllegalArgumentException("set can't be empty");
        }
        if (set == null) {
            throw new NullPointerException("set can't be null");
        }
        List<Set<Integer>> newList = new ArrayList<>();
        for (Set<Integer> elem : list) {
//            кажется надо использовать другой метод:
            if (!elem.contains(set)) {
                newList.add(elem);
            }
        }
        return newList;
    }

    public static Set<Human> getMaxAgeSet(List<Human> list){
        if(list == null){
            throw new NullPointerException("list can't be null");
        }
        if(list.isEmpty()){
            throw new IllegalArgumentException("list can't be empty");
        }
        Set<Human> set = new HashSet<>();
        int max = list.get(0).getAge();
        for (Human elem: list) {
            if (elem.getAge() > max){
                max = elem.getAge();
            }
        }
        for (Human elem: list) {
            if (elem.getAge() == max){
                set.add(elem);
            }
        }
        return set;
    }

}

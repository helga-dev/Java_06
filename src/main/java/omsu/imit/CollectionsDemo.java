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
        if(persons == null){
            throw new IllegalArgumentException("list persons can't be null");
        }

        if (persons.isEmpty()){
            throw new IllegalArgumentException("list persons can't be empty");
        }

        if(person == null){
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

    public static List<Human> copyWithout(List<Human> persons, Human person){
        if(persons == null){
            throw new IllegalArgumentException("list persons can't be null");
        }

        if (persons.isEmpty()){
            throw new IllegalArgumentException("list persons can't be empty");
        }

        if(person == null){
            throw new IllegalArgumentException("person can't be null");
        }

        List<Human> newPersons = new ArrayList<>();
        for (Human p: persons) {
            if (!person.equals(p)){
                newPersons.add(p);
            }
        }

        return newPersons;
    }


    public static List<Set<Integer>> getNotCrossedWith(List<Set<Integer>> intNumSets,
                                                           Set<Integer> intNumSet){
        List<Set<Integer>> notCrossedWith = new ArrayList<>();

        return notCrossedWith;
    }

}

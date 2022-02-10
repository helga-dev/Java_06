package omsu.imit;

import static omsu.imit.CollectionsDemo.countLines;
import static org.junit.Assert.assertTrue;

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
    public void testCountLinesInvalid(){
        List<String> lines = new ArrayList<>();
        lines = Collections.EMPTY_LIST;
    }

    @Test
    public void testCountLinesWithChar(){
        List<String> lines = new ArrayList<String>();
        Collections.addAll(lines, "apple", "orange", "pineapple", "abcde", "acid");
        Assert.assertEquals(3, countLines(lines, 'a'));

    }
}

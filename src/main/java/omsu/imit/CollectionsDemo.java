package omsu.imit;

import java.util.List;

/**
 * Author
 * Created: 2022/02/10
 *
 */
public class CollectionsDemo {
    public static void main( String[] args )
    {

    }

    public static int countLines(List<String> lines, char symbol) {
        int res = 0;
        if (lines.isEmpty()){
            throw new IllegalArgumentException("Список строк пуст");
        }
        else {
            for (String line : lines) {
                if (line.indexOf(symbol) == 0) {
                    res++;
                }
            }
            return res;
        }
    }
    /**
     * 1 list == null
     * 2 list is empty
     * 3 list isnt empty count == 0
     * 4 list isnt empty count != 0
     * 5 list elem == null
     */
}

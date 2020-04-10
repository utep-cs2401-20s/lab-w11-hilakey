import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
public class newSortingTester {
    @Test
    public void testNewSorting1(){
        int[] a = {4, 1, 3, 5, 2};
        newSorting.newSorting(a, 4);
        int[] expected = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));
      //  assertArrayEquals(expected, a);
    }

   //
}

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
public class newSortingTester {

    /* Test #1:
     * This first test is a basic test case in which I pass a small unsorted array of positive numbers. This test was
     * created with the purpose of just checking if newSorting.java behaves correctly. This is basically a dummy test,
     * and it's result of either PASS/FAIL will help me determine if the logic is working. I expect the test to PASS.
     * Input ---> {4, 1, 3, 5, 2}
     * Expected Output ---> {1, 2, 3, 4, 5}
     *
     * PASS/FAIL?-----> PASS
     */
    @Test
    public void testNewSorting1(){
        int[] a = {4, 1, 3, 5, 2};
        newSorting.newSorting(a, 4);
        int[] expected = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));
        assertArrayEquals(expected, a);
    }

    /* Test #2:
     *The second aims to see whether newSorting will sort the given array if there are multiple duplicates inside the array.
     * I chose to do this test because I understand that when sorting algorithms are face with duplicate values to sort
     * it can confuse the logic of the code and mess up the rest of the sorting process if not careful. By me testing duplicates,
     * it will help me fix the error so that the algorithm is not "overwhelmed" and place the values at the correct spots in the
     * array. I expect the test to fail.
     * Input ---> {6, 6, 7, 3, 0, 10, 3, 5, 2}
     * Expected Output ----> {0, 2, 3, 3, 5, 6, 6, 7, 10}
     *
     * PASS/FAIL?-----> FAIL
     */
    @Test
    public void testNewSorting2(){
        int[] a = {6, 6, 7, 3, 0, 10, 3, 5, 2};
        newSorting.newSorting(a, 6);
        int[] expected = {0, 2, 3, 3, 5, 6, 6, 7, 10};
        System.out.println(Arrays.toString(a));
        assertArrayEquals(expected, a);
    }

    /* Test #3:
     * This test checks to see if the algorithm will work correctly if the size given is 0. I chose this value because
     * the newSorting algorithm relies on being <= size, if size is 0, then the condition is never met, thus it should never be able
     * to call on QuickSort to sort the algorithm. With this test, I can make sure that size will be a valid number in the even
     * that the test fails, so that newSorting works the way it should. I expect the test to fail.
     * Input ---> {9, 6, 2, 1, 4, 5} , size = 0
     * Expected Output --> {1, 2, 4, 5, 6, 9}
     *
     * PASS/FAIL?-----> FAIL
     */
    @Test
    public void testNewSorting3(){
        int[] a = {9, 6, 2, 1, 4, 5};
        newSorting.newSorting(a, 0);
        int[] expected = {1, 2, 4, 5, 6, 9};
        System.out.println(Arrays.toString(a));
        assertArrayEquals(expected, a);

    }

    /* Test #4:
     * Given an array with negatives, I am testing the logic to ensure that values less than 0 are sorted
     *
     **/


}

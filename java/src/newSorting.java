import java.rmi.activation.ActivationGroup_Stub;
import java.util.Arrays;

public class newSorting {
    public static void newSorting(int[] A, int size){
        /* base case */
        if(A.length <= size){
            /* make a recursive call to QuickSort */
            quickSort(A);
        }else{
            int mid = A.length/2;
            int[] LH = new int[mid];
            int[] RH = new int[A.length-mid];
            /*call the helper method populate()*/
            populate(A, LH, RH);

            newSorting(LH,size); /* sort the left half of A*/
            newSorting(RH, size); /* sort the right half of A*/


            /* with the two halves sorted, now we merge them
             * by calling mergeSortedHalves().*/
            //System.out.println(Arrays.toString(LH));
            //System.out.println(Arrays.toString(RH));
            //System.out.println(Arrays.toString(A));
            mergeSortedHalves(LH, RH, A);
        }
    }

    public static void quickSort(int[] a){
        /* base case*/
        if(a.length <= 1){
            //if a's size <= 1, then by default the array is sorted and we do nothing.
            System.out.println();
        }else{
            /* first we define our pivot*/
            int pivot = a[0]; //we set it as the value of the first element in our array.
            int less = 1; //the 'less' pointer covers values that are <= pivot
            int more = a.length-1; // the 'more' pointer covers values that are > pivot.

            /* begin partitioning the array*/
            while(less < more){
                while(less <= a.length-1 && a[less] <= pivot){
                    less++;
                }
                while(more >= 1 && a[more] > pivot){
                    more--;
                }
                 if(less < more){
                    int temp = a[less];
                    a[less] = a[more];
                    a[more] = temp;
                }
            }
            /*we now swap the pivot with the value at index 'more'*/
            int temp = pivot;
            a[0] = a[more];
            a[more] = temp;
            int[] unsortedLeft = new int[more];
            int[] unsortedRight = new int[a.length-more];
            populate(a, unsortedLeft, unsortedRight);

            /*make a recursive call on the unsorted halves*/
            quickSort(unsortedLeft);
            quickSort(unsortedRight);
        }

    }


    /* the helper method populate() creates the left and right half arrays for the original
     * array A(the one we want to sort) and populates them, so that each half can be sorted
     * with quickSort.
     */
    public static void populate(int[] a, int[] left, int[] right){
        /*populate the left half and right half arrays.*/
        int mid = a.length/2;
        int k = 0;
        while(k < right.length) {
            for (int i = 0; i < a.length; i++) {
                if (i < mid) {
                    //populate the left half
                    left[i] = a[i];
                } else if (i >= mid) {
                    //populate the right half
                    right[k] = a[i];
                    k++;
                }
            }
        }

    }

    public static void mergeSortedHalves(int[] LH, int[] RH, int[] A){
            int A_index; // iterator that goes through A
            int L_index = 0; //iterator that goes through the left half
            int R_index = 0; // iterator that goes through the right half


           for(A_index = 0; A_index < A.length; A_index++ ){
               if(L_index >= LH.length){
                   A[A_index] = RH[R_index];
                   R_index++;
               }
               else if(R_index >= RH.length){
                   A[A_index] = LH[L_index];
                   L_index++;
               }
               if(L_index >= LH.length && R_index >= RH.length){
                   continue;
               }


               if(LH[L_index]< RH[R_index]){
                   A[A_index] = LH[L_index];
                   L_index++;
               }else if(LH[L_index]> RH[R_index]){
                   A[A_index] = RH[R_index];
                   R_index++;
               }
           }
    }
}

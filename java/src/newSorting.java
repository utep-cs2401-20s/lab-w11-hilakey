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
            mergeSortedHalves(LH, RH, A);
        }
    }

    public static void quickSort(int[] a){
        /* base case*/
        if(a.length <= 1){
            //if a's size <= 1, then by default the array is sorted and we do nothing.
            System.out.println("array is sorted");
        }else{
            /* first we define our pivot*/
            int pivot = a[0]; //we set it as the value of the first element in our array.
            int less = 1; //the 'less' pointer covers values that are <= pivot
            int more = a.length-1; // the 'more' pointer covers values that are > pivot.

            /* begin partitioning the array*/
            while(less < more){
                if(less <= a.length-1 && a[less] <= pivot){
                    less++;
                }
                if(more >= 1 && a[more] > pivot){
                    more++;
                }

                if(less > more){
                    int temp = a[less];
                    a[less] = a[more];
                    a[more] = temp;
                }
            }
            /*we now swap the pivot with the value at index 'more'*/
            int temp = pivot;
            a[0] = a[more];
            a[more] = temp;
            int[] unsortedLeft = new int[pivot];
            int[] unsortedRight = new int[a.length-pivot];

            /*make a recursive call on the unsorted halves*/
            quickSort(unsortedLeft);
            quickSort(unsortedRight);
        }

    }


    /* the helper method populate() creates the left and right half arrays for the original
     * array A(the one we want to sort) and populates them, so that each half can be sorted
     * with quickSort.
     */
    public static void populate(int[] A, int[] left, int[] right){
        int mid = A.length/2;

        /*populate the left half and right half arrays.*/
        for(int i = 0; i < A.length; i++){
            if(i < mid){
                //populate the left half
                left[i] = A[i];
            }else{
                //populate the right half
                right[i] = A[i];
            }
        }

    }

    public static void mergeSortedHalves(int[] LH, int[] RH, int[] A){
        int k = 0; //iterator for the left half
        int j = 0; //iterator for the right half
        int i = 0; // iterator for A

        while(i < A.length){
            //if the iterators j or k are out of bounds, then populate the rest of A with the remaining values.
            if(k == LH.length){
                A[i] = RH[j];
                j++;
                i++;
            }
            if(j == RH.length){
                A[i] = LH[k];
                k++;
                i++;
            }
            // the two if statements here are how the pointers j and k navigate through the left and right halves.
            // and compare their values.
            if(LH[k] < RH[j]){
                A[i] = LH[k];
                k++;
                i++;
            }
            if(RH[j] < LH[k]){
                A[i] = RH[j];
                j++;
                i++;
            }
        }
    }
}

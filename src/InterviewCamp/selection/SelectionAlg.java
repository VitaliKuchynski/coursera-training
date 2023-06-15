package InterviewCamp.selection;

import java.util.Random;

public class SelectionAlg {

    public static void main(String[] args) {

        int [] input = {8,5,7,6,5,3,3};

        System.out.println(findKthElement(input, 3));

    }

    //Level: Hard Find the Kth the smallest element in a given array of integers
    public static int findKthElement(int[] ints, int k) {

        if (ints == null || ints.length == 0 || k < 1 || k > ints.length) {
            throw new IllegalArgumentException();
        }

        return selectionAlg(ints, 0, ints.length - 1, k - 1 /* target index */);

    }

    public static int selectionAlg(int[] ints, int start, int end, int targetIndex) {
        // Get random index
        int pivot  = new Random().nextInt(end - start + 1) + start;

        // partitioning less grate than pivot
        int result = singlePlacementPartition(ints, start, end, pivot);

        if (result > targetIndex) {
            // search in first part
            return selectionAlg(ints, start,result - 1, targetIndex);
        } else if (result < targetIndex) {
            // search in second
            return selectionAlg(ints,result + 1, end, targetIndex);
        } else {
            return ints[result];
        }
    }


   public static int singlePlacementPartition(int[] ints, int start, int end, int pivot) {

        swap(ints, start, pivot);
        int less = start;

       for (int i = start + 1; i <= end ; i++) {

           if (ints[i] <= ints[start]) {
               swap(ints, i, ++less);
           }
       }

       swap(ints, start, less);
       return less;
   }

   public static void swap(int [] a, int index, int swapIndex) {
        int temp = a[index];
        a[index] = a[swapIndex];
        a[swapIndex] = temp;
   }

}

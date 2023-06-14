package InterviewCamp.selection;

import java.util.Random;

public class SelectionAlg {

    public static void main(String[] args) {

        int [] input = {5,7,4,6,5,3,3};

        System.out.println(findKthElement(input, 3));

    }

    public static int findKthElement(int[] ints, int k) {

        if (ints == null || ints.length == 0 || k < 1 || k > ints.length) {
            throw new IllegalArgumentException();
        }

        return selectionAlg(ints, 0, ints.length - 1, k - 1 /* target index */);

    }

    public static int selectionAlg(int[] ints, int start, int end, int targetIndex) {
        // Get random index
        int pivot  = new Random().nextInt(end - start + 1) + start;

        int result = singlePlacementPartition(ints, start, end, pivot);

        if (result > targetIndex) {
            return singlePlacementPartition(ints, start,result - 1, targetIndex);
        } else if (result < targetIndex) {
            return singlePlacementPartition(ints, start,result + 1, targetIndex);
        } else {
            return ints[result];
        }
    }


   public static int singlePlacementPartition(int[] ints, int start, int end, int pivot) {

        int temp = ints[pivot];
        ints[pivot] = ints[start];
        ints[start] = temp;
        int less = start;

       for (int i = start + 1; i <= end ; i++) {

           if (ints[i] <= ints[start]) {
               int tempr = ints[i];
               ints[i] = ints[++less];
               ints[less] = tempr;
           }

       }

       int tempr = ints[less];
       ints[less] = ints[start];
       ints[start] = tempr;
       return less;
   }

}

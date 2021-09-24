package InterviewCamp.binarySearch;

public class FindInsertionIndex {
    //Level: Easy You are given a sorted array A and a target T.
    // Return the index where it would be placed if inserted in order

    public static void main(String[] args) {
                    // 0  1  2  3  4  5  6  7  8
        int[] input = {1, 2, 3, 3, 4, 4, 5, 6, 8};
        int target = 2;

        System.out.println(returnInsertionIndex(input, target));
   }


    public static int returnInsertionIndex(int[] ints, int target) {

        if (ints == null) {
            return - 1;
        }
        if (ints.length == 0) {
            return 0;
        }

        int start = 0, end = ints.length - 1;

        while (start <= end) {

            int mid = start + (end - start)/2;

             if (ints[mid] <= target) { // if array is single element (equal/not equal) to target and if all elements less than target
                 if (mid == ints.length - 1) {
                     return ints.length;
                 }
                 start = mid + 1;

             } else {
                 if (mid == 0 || ints[mid - 1] <= target) { // if all elements are greater than target return 0
                     return mid;
                 }
                 end = mid - 1;
             }
        }
        return -1;
    }

}

package InterviewCamp.twoPointers;

public class ShortestUnsortedSubarrayToSortArray {

    // Problem: Shortest Unsorted Subarray to Sort the Array
// Level: Medium
// Given an array of integers, find the shortest sub array,
// that if sorted, results in the entire array being sorted.

    public static void main(String[] args) {
                 // 0 1 2 3 4 5 6
        int[] ar = {0,2,3,1,8,6,9};
        shortSub(ar);
    }

    public static int[] shortSub(int[] ints) {

        if (ints == null || ints.length == 0) {
            return null;
        }

        int left, right;

        for (left = 0; left < ints.length - 1; left++) {
            if (ints[left + 1] < ints[left]) {
                break;
            }
        }

        if (left == (ints.length - 1)) {
            return null;
        }

        for (right = ints.length - 1; right > 0; right--) {
            if (ints[right - 1] > ints[right]) {
                break;
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (ints[i] > maxValue)
                maxValue = ints[i];
            if (ints[i] < minValue)
                minValue = ints[i];

        }

        while (ints[left - 1] > minValue && left > 0) {
            left--;
        }

        while (right < (ints.length - 1) && ints[right + 1] < maxValue) {
            right++;
        }

        for (int i = left; i <= right; i++) {
            System.out.println(ints[i]);

        }
        return null;
    }
}

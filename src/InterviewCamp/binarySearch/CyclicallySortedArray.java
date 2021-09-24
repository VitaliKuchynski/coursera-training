package InterviewCamp.binarySearch;

public class CyclicallySortedArray {

    // Level: Easy Given an array that is cyclically sorted, find the minimum element.
    // A cyclically sorted array is a sorted array rotated by some number of elements. Assume all elements are unique.

    public static void main(String[] args) {

        int[] input = {4,5,6,1,2,3};

        System.out.println(cyclicallySortedMin(input));
    }

    public static  int cyclicallySortedMin(int[] ints) {

        if (ints == null) {
            return - 1;
        }

        int start = 0, end = ints.length - 1;
        int right = ints[ints.length - 1];

        while (start <= end) {

            int mid = start + (end - start)/2;

            if(ints[mid] <= right && (mid == 0 || ints[mid - 1] > ints[mid])) {
                return mid;
            } else if  (ints[mid] > right) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}

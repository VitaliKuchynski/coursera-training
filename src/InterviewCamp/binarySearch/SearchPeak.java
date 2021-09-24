package InterviewCamp.binarySearch;

public class SearchPeak {
    //Level: Medium
    // A peak element in an array A is an A[i] where its neighboring elements are less than A[i].
    // So, A[i - 1] < A[i] and A[i + 1] < A[i].
    // Assume there are no duplicates.
    // Also, assume that A[-1] and A[length] are negative infinity (-∞).
    // So A[0] can be a peak if A[1] < A[0].
    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4, 5, 8, 9, 10};


        System.out.println(findPeak(input));

    }

    public static int findPeak(int[] ints) {
        if (ints == null || ints.length == 0) {
            return -1;
        }

        int start = 0, end = ints.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            int left = (mid > 0) ? ints[mid - 1] : Integer.MIN_VALUE;
            int right = (mid < ints.length - 1) ? ints[mid + 1] : Integer.MIN_VALUE;

            if (left < ints[mid] && right > ints[mid]) {
                start = mid + 1; // go right
            } else if (right < ints[mid] && left > ints[mid]) {
                end = mid - 1; // go left
            } else  if (right > ints[mid] && left > ints[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return - 1;
    }
}

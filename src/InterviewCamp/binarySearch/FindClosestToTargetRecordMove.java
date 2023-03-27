package InterviewCamp.binarySearch;

public class FindClosestToTargetRecordMove {

//(Level: Easy) Given a sorted array A and a target T, find the target.
// If the target is not in the array, find the number closest to the target

    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4, 5, 8, 9, 10};
        int target = 6;

        System.out.println(findClosestToTarget(input, target));
    }


    public static int findClosestToTarget(int[] ints, int target) {

        if (ints == null || ints.length == 0) {
            return - 1;
        }

        int start = 0, end = ints.length - 1;
        int result = -1;

        while (start <= end) {

            int mid = start + (end - start)/2;

            result = record(ints, mid, result, target);

            if (ints[mid] > target || mid > 0 && ints[mid] == target && ints[mid - 1] == target) {
                end = mid - 1;
            } else if (ints[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return result;
    }

    private static int record(int[] a, int mid, int result, int target) {

        if (result == -1 || Math.abs(a[mid] - target) < Math.abs(a[result] - target)) {
            return mid;
        }
        return result;
    }



}

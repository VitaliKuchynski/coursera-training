package InterviewCamp.binarySearch;

public class SearchArrayUnknownLength {

//    Search Array of Unknown length You are given an array, but you don't know the length.
//    Write a program to find a target element in the array.

    public static void main(String[] args) {
                    // 0  1  2  3  4
        int[] input = {1, 3, 4, 5, 6};
        int target = 6;
        System.out.println(findWithUnknownLength(input, target));
    }

    public static int findWithUnknownLength(int[] ints, int target) {

        if (ints == null || ints.length == 0) {
            return -1;
        }

        int high = 1;
        int lastIndex = -1;

// Consider putting a sanity limit here, for e.g,don't go more
// than index 1 million. Discuss this with the interviewer.

        while (true) {

            try {
                int tmp = ints[high];
            } catch (ArrayIndexOutOfBoundsException e) {
                lastIndex = binarySearchForLastIndex(ints, high / 2, high);
                break;
            }
            high *= 2;
        }
       return binarySearchOverRange(ints, target, 0, lastIndex);

    }


    private static int binarySearchForLastIndex(int[] a, int low, int high) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            try {
                int temp = a[mid];
            } catch (ArrayIndexOutOfBoundsException e) {
                // mid is out of bounds, go to lower half
                high = mid - 1;
                continue;
            }

            try {
                int temp = a[mid + 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                // mid + 1 is out of bounds, mid is last index
                return mid;
            }
            // both mid and mid + 1 are inside array, mid is not last index.
            low = mid + 1;
        }
        return -1; // this subarray does not have end of the array
    }

    private static int binarySearchOverRange(int[] a, int target, int low, int high) {

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (a[mid] == target) {
                return mid;

            } else if (a[mid] < target) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

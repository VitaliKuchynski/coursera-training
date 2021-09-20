package InterviewCamp.binarySearch;

public class BinarySearchWithDuplicates {

    //Given a sorted array, search for a target item.

/*   Key Concepts
1. Works only on sorted arrays
2. Divides the decision by half on every iteration
3. O(log(n)) search time
4. When calculating middle element, instead of using
    mid = (start + end)/2, use
    mid = start + (end - start)/2
 */

    public static void main(String[] args) {

        int[] input = {1, 2, 3, 3, 4, 4, 5, 6, 6, 7, 8, 9, 10};
        int target = 6;

        System.out.println(binarySearchDuplicates(input, target));
    }

    public static int binarySearch(int[] ints, int target) {

        if (ints == null || ints.length == 0) {
            return - 1;
        }

        int start = 0, end = ints.length - 1;

        while (start <= end) {

            int mind = start + (end - start)/2;

            if (ints[mind] > target) {
                end = mind - 1;
            } else if (ints[mind] < target) {
                start = mind + 1;
            } else {
                return mind;
            }
        }
        return - 1;

    }
//Given a sorted array that can contain duplicates,
// find the first occurrence of the target element.

    public static int binarySearchDuplicates(int[] ints, int target) {

        if (ints == null || ints.length == 0) {
            return - 1;
        }

        int start = 0, end = ints.length - 1;

        while (start <= end) {

            int mind = start + (end - start)/2;

            if (ints[mind] > target || ints[mind] == target && mind > 0 && ints[mind - 1] == target) {
                end = mind - 1;
            } else if (ints[mind] < target) {
                start = mind + 1;
            } else {
                return mind;
            }

        }
        return - 1;

    }

    // comparable

    public static <T extends Comparable<T>> int search(T[] input, T target) {

        if (input == null || input.length == 0) {
            return  - 1;
        }

        int start = 0; int end = input.length - 1;

        while (start <= end) {

            int mid = start + (end - start)/2;

            if (input[mid].compareTo(target) == 0) {
                return mid;
            } else if (input[mid].compareTo(target) < 0) {
                start = mid + 1;
            } else {
               end = mid - 1;
            }

        }
            return  -1;
    }


}

package InterviewCamp.binarySearch;

public class BinarySearchOverIntegerSpace {

// Easy:    Find the square root of an integer X. For example, squareRoot(4) = 2.
//    If X is not a perfect square, find the integer floor of the square root

    public static void main(String[] args) {
        System.out.println(floorSquareRoot(10));
    }

public static int floorSquareRoot(int initial) {

        if (initial == 0) {
            return 0;
        }

        if (initial == 1) {
            return 1;
        }

        int start = 0, end = initial / 2;

        while (start <= end) {

            int mid = start + (end - start)/2;

            if (square(mid) > initial) {
                end = mid - 1;
            } else if (square(mid) < initial) {
                if (square(mid + 1) > initial) {
                    return mid;
                }
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static long square(int x) {
        return x * x;
    }

}

package InterviewCamp.twoPointers;

import java.util.Arrays;

public class SortedSquares {
//    Level: Easy
//    Given a sorted array in non-decreasing order,
//    return an array of squares of each number, also in non-decreasing order.
//      Time Complexity: O(n)
//      Space Complexity: O(n)

    public static void main(String[] args) {

        int[] ints = {-6, -5, -4, -2, -1, 0, 3, 5};

        System.out.println(Arrays.toString(squaresInt(ints)));

    }

    public static int[] squaresInt(int[] ints) {

        if(ints == null || ints.length == 0) {
            return null;
        }

        int start = 0, end = ints.length - 1;
        int[] result = new int[ints.length];
        int resultIndex = result.length - 1;

        while (start <= end) {
            if(convertNeg(ints[start])>convertNeg(ints[end])) {
                result[resultIndex] = inSquare(ints[start]);
                start++;
            } else {
                result[resultIndex] = inSquare(ints[end]);
                end--;
            }
            resultIndex--;
        }

        return result;
    }

    public static int convertNeg(int numb) {
        return numb >=0 ? numb : -1 * numb;
    }

    public static int inSquare(int entry) {
        return entry * entry;
    }








    public static int[] squares(int[] intsArray) {

        if (intsArray == null || intsArray.length == 0) {
            return null;
        }

        int start = 0, end = intsArray.length - 1;
        int[] result = new int[intsArray.length];
        int resultIndex = result.length - 1;

        while (start <= end) {

            if(convertNegative(intsArray[start]) > convertNegative(intsArray[end])) {
                result[resultIndex] = square(intsArray[start]);
                start++;
            } else {
                result[resultIndex] = square(intsArray[end]);
                end--;
            }
            resultIndex--;

        }
        return result;
    }

    public static int convertNegative(int num) {
        return num >= 0 ? num : - 1 * num;

    }

    public static int square(int num) {
        return num * num;
    }

}

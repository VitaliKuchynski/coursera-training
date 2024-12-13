package InterviewCamp.recursion;

// Have the function ArrayChallenge(arr) take the array of numbers stored in arr and return the string true
// if any two numbers can be multiplied so that the answer is greater
// than double the sum of all the elements in the array.
// If not, return the string false.
// For example: if arr is [2, 5, 6, -6, 16, 2, 3, 6, 5, 3]
// then the sum of all these elements is 42 and doubling it is 84.
// There are two elements in the array, 16 * 6 = 96 and 96 is greater than 84,
// so your program should return the string true.
// Examples
// Input: [2, 2, 2, 2, 4, 1]
// Output: false
// Input: [1, 1, 2, 10, 3, 1, 12]
// Output: true

import java.util.Arrays;

public class DoubleSumArrayProblem {

    public static void main(String[] args) {

        int[] ar = {1, 1, 2, 10, 3, 1, 10};

        System.out.println(isGreater(ar));

    }


    public static String isGreater(int [] ar) {

        int arraySum = Arrays.stream(ar).sum() * 2;
        int[] buffer = new int[2];

        if (lookGreaterHelper(ar, buffer, 0, 0, arraySum)) {
            return "true";
        }
        return "false";
    }

    public static boolean lookGreaterHelper(int[] arr, int[] buffer, int indexAr, int indexBuf,  int arraySum) {
        if (buffer.length == indexBuf) {
            return buffer[0] * buffer[1] > arraySum;
        }

        for (int i = indexAr; i < arr.length; i++) {
            buffer[indexBuf] = arr[i];

            if (lookGreaterHelper(arr, buffer, i + 1, indexBuf + 1, arraySum)) {
                return true;
            }
        }

        return false;
    }
}

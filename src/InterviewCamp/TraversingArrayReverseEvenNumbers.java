package InterviewCamp;

import java.util.Arrays;

public class TraversingArrayReverseEvenNumbers {

    //(Level: Easy) Given an array of numbers, replace each even number with two of the same number.
    // e.g, [1,2,5,6,8] -> [1,2,2,5,6,6,8,8].
    // Assume that the array has enough space to accommodate the result.

    public static void main(String[] args) {
                         //  0  1  2  3  4   5   6   7   8  9   10
        int [] origArray = {0, 4, 1, 2, 70, 11, 15, -1, -1, -1, -1};

        System.out.println(Arrays.toString(cloneEvenNumbers(origArray)));

    }

    public static int [] cloneEvenNumbers(int[] inputArray) {
        int endOfArray = inputArray.length;
        int lastValidValue = findLastNumber(inputArray);

        if (inputArray == null || inputArray.length == 0)
            return inputArray;

        while (lastValidValue >= 0) {

            if(inputArray[lastValidValue] % 2 == 0) {
                endOfArray--;
                inputArray[endOfArray] = inputArray[lastValidValue];
                endOfArray--;
                inputArray[endOfArray] = inputArray[lastValidValue];
            } else {
                endOfArray--;
                inputArray[endOfArray] = inputArray[lastValidValue];
            }
                lastValidValue--;
        }

        return inputArray;
    }

    public static int findLastNumber (int[] inputArray) {
        for (int i = inputArray.length - 1; i > 0; i-- ) {
            if(!(inputArray[i] == -1)){
                return i;
            }
        }
        throw new RuntimeException();
    }
}
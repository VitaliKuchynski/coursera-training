package InterviewCamp.partitioningArray;

import java.util.Arrays;

public class DutchNationalProblem {

    //Level: Medium You are given an array of integers and a pivot.
    // Rearrange the array in the following order:[all elements less than pivot,
    // elements equal to pivot, elements greater than pivot
    //Time Complexity: O(n)
    // Space Complexity: O(1)
    //a = [5,2,4,4,6,4,4,3] and pivot = 4 --> result = [3,2,4,4,4,4,5,6].

    public static void main(String[] args) {
                          //0  1  2  3  4  5  6  7  8
        int[] inputArray = {9, 5, 2, 4, 4, 6, 4, 4, 3};
        int pivot = 4;

        System.out.println(Arrays.toString(rearrangeArrayTreeSections(inputArray, pivot)));

    }


    public static int[] rearrangeArrayTreeSections(int[] inputArray, int pivot) {

        if (inputArray == null || inputArray.length == 0){
            return null;
        }

        int lowBoundary = 0, highBoundary = inputArray.length - 1;
        int i = 0;

        while (i < highBoundary) {

            if (inputArray[i] < pivot) {
                int temp = inputArray[lowBoundary];
                inputArray[lowBoundary] = inputArray[i];
                inputArray[i] = temp;
                lowBoundary++;
                i++;
            } else if (inputArray[i] > pivot) {
                int temp = inputArray[highBoundary];
                inputArray[highBoundary] = inputArray[i];
                inputArray[i] = temp;
                highBoundary--;
            } else {
                i++;
            }
        }
        return inputArray;
    }
}

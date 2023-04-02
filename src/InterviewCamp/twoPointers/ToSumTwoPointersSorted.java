package InterviewCamp.twoPointers;

import java.util.Arrays;

public class ToSumTwoPointersSorted {


    // NOTE SORTED ARRAY

    public static void main(String[] args) {

        int[] intsArray = {1,2,3,5,6,7};

        System.out.println(Arrays.toString(twoSum(intsArray, 11)));

    }


    public static int[] twoSum(int[] inputsArray, int target) {

        int[] finalOutput = new int[2];

        if (inputsArray.length == 0 || inputsArray == null){
            return inputsArray;
        }

        int start = 0, end = inputsArray.length - 1;

        while(start < end) {

            int sum = inputsArray[start] + inputsArray[end];

            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
            finalOutput[0] = inputsArray[start];
            finalOutput[1] = inputsArray[end];
            return finalOutput ;
            }
        }
            return null ;
    }

}

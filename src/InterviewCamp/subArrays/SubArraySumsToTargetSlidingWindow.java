package InterviewCamp.subArrays;

import java.util.Arrays;

public class SubArraySumsToTargetSlidingWindow {

    //Level: Medium Given an array of positive integers,
    // find a subarray that sums to a given number X.
    // For e.g, input = [1,2,3,5,2] and X=8, Result = [3,5] (indexes 2,3)

    public static void main(String[] args) {

        int [] inputInts = {1, 6, 7, 8, 1, 5, 4};
        int tar = 9;
        System.out.println("Maximum sum is " + Arrays.toString(subarraySum(inputInts, tar)));

    }

    public static int[] subarraySum(int[] ints, int target) {

        int[] result = new int[2];

        if (ints.length == 0 || ints == null) {
            return null;
        }

        int start = 0, end = 0, currentSum = ints[0];

        while (start < ints.length - 1) {

            if (start > end) {
                start = end;
                currentSum = ints[start];
            }

            if (currentSum < target) {
                if (end == ints.length - 1) {
                    break;
                }

                end++;
                currentSum += ints[end];
            } else if (currentSum > target) {
                currentSum -= ints[start];
                start++;
            } else {
                result[0] = start;
                result[1] = end;
                return result;
            }

        }
    return null;

    }
}

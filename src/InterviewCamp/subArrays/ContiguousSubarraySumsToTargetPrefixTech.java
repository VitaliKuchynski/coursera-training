package InterviewCamp.subArrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousSubarraySumsToTargetPrefixTech {
// Given an array of integers, both -ve and +ve,
// find a contiguous subarray that sums to a numberX


    public static void main(String[] args) {

        int[] input = {2, 4, -2, 1, -3, 5, -3, 1};
        int target = 4;

        System.out.println(Arrays.toString(targetSumSubarray(input, target)));

    }

    public static int[] targetSumSubarray(int[] ints, int target) {

        int sum = 0;
        int[] result = new int[2];

        Map<Integer, Integer> countSum = new HashMap<>();


        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];

            if(sum == target){
                result[0] = 0;
                result[1] = i;
                return result;
            }
            if (countSum.containsKey(sum  - target)) {
                result[0] = countSum.get(sum - target) + 1;
                result[1] = i;
                return result;
            }
            countSum.put(sum, i);
        }
            return null;
    }
}

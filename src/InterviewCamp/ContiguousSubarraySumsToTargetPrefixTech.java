package InterviewCamp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousSubarraySumsToTargetPrefixTech {
// Given an array of integers, both -ve and +ve,
// find a contiguous subarray that sums to a numberX


    public static void main(String[] args) {

        int[] input = {2, 4, -2, 1, -3, 5, -3, 1};
        int target = 4;

        System.out.println(Arrays.toString(subTarg(input, target)));

    }



public static int[] subTarg(int[] ints, int target) {

        if (ints.length == 0 || ints == null) {
            return null;
        }

        int[] result = new int[2];

        int currentSum = 0;
        Map<Integer, Integer> count = new HashMap<>();

         for (int i = 0; i < ints.length - 1; i++) {
             currentSum += ints[i];

             if (currentSum == target) {
                 result[0] = 0;
                 result[1] = i;
                 return result;
             }

         if (count.containsKey(currentSum - target)){

             result[0] = count.get(currentSum - target) + 1;
             result[1] = i;
             return result;
         }
            count.put(currentSum, i);
         }
        return null;
}

    public static int[] toTargetInArray(int[] ints, int target) {

        if (ints == null || ints.length == 0) {
            return null;
        }

        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int[] result  = new int[2];

        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];

            if (sum == target){
                result[0] = 0;
                result[1] = i;
                return result;
            }

            if (count.containsKey(sum - target)) {
                result[0] = count.get(sum - target) + 1;
                result[1] = i;
                return result;
            } else
                count.put(sum, i);
        }
        return null;
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
            } countSum.put(sum, i);
        }
            return null;
    }
}

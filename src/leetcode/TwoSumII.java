package leetcode;

import java.util.Arrays;

/**
 * Created by vitalikuchynski on 6/13/20.
 */
public class TwoSumII {

    public static void main(String[] args) {

        int [] origArray = {2, 3, 4};

        System.out.println(Arrays.toString(twoSum(origArray, 6)));

    }

    public static int[] twoSum(int[] numbers, int target) {

        int [] result = new int[2];

        for (int i = 0; i < numbers.length ; i++) {

            for (int j = i + 1; j < numbers.length ; j++) {

                if(numbers[i] + numbers [j] == target){
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;

                }
            }
        }

        return result;
    }

}

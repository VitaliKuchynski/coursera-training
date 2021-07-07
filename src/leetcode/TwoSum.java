package leetcode;

import java.util.Arrays;

/**
 * Created by vitalikuchynski on 5/26/20.
 */
public class TwoSum {

    public static void main(String[] args) {
        int [] origArray = {0, 1, 2, 70, 11, 15, 7};

        System.out.println(Arrays.toString(twoSum(origArray, 9)));

    }

    public static int[] twoSum(int[] nums, int target) {

        int [] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }

        }

        return result;
    }
}

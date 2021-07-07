package leetcode;

import java.util.Arrays;

/**
 * Created by vitalikuchynski on 7/26/20.
 */
public class MoveZeroes {

    public static void main(String[] args) {
                    //  0  1  2  3  4
        int [] nums = {1, 1, 0, 0, 12};

        System.out.println(Arrays.toString(moveZeroes(nums)));
        String t = "string";
        int i = 1;

    }

    public static int [] moveZeroes(int[] nums) {

        int counter = 0;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] != 0){

                int tem = nums[counter];
                nums[counter] = nums[i];
                nums[i] = tem;
                counter++;
            }
        }
        return nums;
    }
}

package leetcode;

import java.util.Arrays;

/**
 * Created by vitalikuchynski on 6/18/20.
 */
public class SortArray {

    public static void main(String[] args) {
                    //0  1  2  3  4  5  6  7
        int[] nums = {1, 2, 4, 8, 5, 9, 6, 3, 7};

        System.out.println(Arrays.toString(sortArray(nums)));
    }

    public static int[] sortArray(int[] nums){

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                int minimum = nums[i];
                int max = nums[j];

                if(nums[i] > nums[j]){
                    nums[j] = minimum;
                    nums[i]= max;
                }
            }
        }

        return nums;
    }

}

package leetcode;

import java.util.Arrays;

/**
 * Created by vitalikuchynski on 6/24/20.
 */
public class BubbleSort {

    public static void main(String[] args) {

                    //0  1  2  3  4  5  6  7
        int[] nums = {1, -2, 4, 8, 5, 9, 6, 3, 7, 12, 100};

        int temp;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length - 1 - i; j++) {

                if(nums[j] > nums[j + 1]){
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }

        }

        System.out.println(Arrays.toString(nums));

    }
}

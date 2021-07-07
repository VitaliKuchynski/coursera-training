package leetcode;

import java.util.Arrays;

/**
 * Created by vitalikuchynski on 6/22/20.
 */
public class SelectionSort {

    public static void main(String[] args) {
                    //0  1  2  3  4  5  6  7
        int[] nums = {1, -2, 4, 8, 5, 9, 6, 3, 7, 12};

        selectionSortFromLowerValue(nums);
        selectionSortArray(nums);
        selectionSort(nums);
    }

    public static void selectionSortArray(int[] nums){

        int currentMax = Integer.MIN_VALUE;
        int maxIndex = 0;
        int lastIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j <= lastIndex; j++) {

                if(nums[j] > currentMax){
                    currentMax = nums[j];
                    maxIndex = j;
                }
            }

            nums[maxIndex] = nums[lastIndex];
            nums[lastIndex--] = currentMax;
            currentMax = Integer.MIN_VALUE;
        }

        System.out.println(Arrays.toString(nums));
    }


    public static void selectionSortFromLowerValue(int [] nums){

        int currentMin = Integer.MAX_VALUE;
        int minIndex = 0;
        int firstIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = firstIndex; j < nums.length ; j++) {

                if (nums[j] < currentMin) {
                    currentMin = nums[j];
                    minIndex = j;

                }
            }
            nums[minIndex] = nums[firstIndex];
            nums[firstIndex++] = currentMin;
            currentMin = Integer.MAX_VALUE;

        }

        System.out.println(Arrays.toString(nums));
    }

    public static void selectionSort(int[] nums){

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int lastIndex = nums.length - 1;

            while (lastIndex > 0){

                for (int i = 0; i <= lastIndex; i++) {

                    if (nums[i] > max) {
                        max = nums[i];
                        maxIndex = i;
                    }
                }

                nums[maxIndex] = nums[lastIndex];
                nums[lastIndex--] = max;
                max = Integer.MIN_VALUE;
            }

        System.out.println(Arrays.toString(nums));
    }

}

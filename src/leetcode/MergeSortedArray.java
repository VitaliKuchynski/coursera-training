package leetcode;

import java.util.Arrays;

/**
 * Created by vitalikuchynski on 5/31/20.
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};  //m = 3
        int[] nums2 = {2, 5, 6};           //n = 3

        merge(nums1, 3, nums2, 3);


    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int currentIndex = m + n - 1 ;

        while (pointer1 >= 0 && pointer2 >= 0) {

            if (nums1[pointer1] > nums2[pointer2]) {
                nums1[currentIndex] = nums1[pointer1];
                pointer1--;
            } else  {
                nums1[currentIndex] = nums2[pointer2];
                pointer2--;
            }
            currentIndex--;
        }

        while (pointer2 >= 0) {
            nums1[currentIndex--] = nums2[pointer2--];
        }

        System.out.println(Arrays.toString(nums1));
    }
}

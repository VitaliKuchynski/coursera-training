package leetcode;

/**
 * Created by vitalikuchynski on 5/28/20.
 */
public class MaximumSubarray {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int localMax = nums[0];

        if (localMax < 0) {
            localMax = 0;
        }

        for (int i = 1; i < nums.length; i++) {

            localMax += nums[i];

            if (localMax > globalMax) {
                globalMax = localMax;
            }

            if (localMax < 0) {
                localMax = 0;
            }
        }

        return globalMax;
    }
}

package leetcode;

/**
 * Created by vitalikuchynski on 5/27/20.
 */
public class SearchInsertPosition {


    public static void main(String[] args) {
        //             0   1   2   3   4   5
        int[] nums = {20, 30, 50, 60, 70, 90};

        System.out.println(searchInsert(nums,120));

    }

    public static int searchInsert(int[] nums, int target) {

            for (int i = 0; i < nums.length; i++) {

                    if(target <= nums[i]){
                        return i;
                    }
            }

            return nums.length;
    }
}

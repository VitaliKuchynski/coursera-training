package leetcode;

import java.util.HashMap;

/**
 * Created by vitalikuchynski on 6/15/20.
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {

        int[] nums = {1,2,3,1,2,3};

        System.out.println(containsDuplicate(nums,2));

    }

    public static boolean containsDuplicate(int[] nums, int k) {

      HashMap<Integer, Integer> set = new HashMap<>();

        for (int i = 0; i < nums.length ; i++) {

            if(set.containsKey(nums[i]) && set.get(nums[i]) - i >= k){
                return true;
            }
            set.put(nums[i], i);
        }
        return false;
    }


}

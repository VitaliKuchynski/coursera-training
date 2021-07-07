package leetcode;

/**
 * Created by vitalikuchynski on 5/27/20.
 */
public class RemoveElement {

    public static void main(String[] args) {

        RemoveElement removeElement =  new RemoveElement();

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};

        System.out.println(removeElement.removeElement(nums,2));
    }


    public int removeElement(int[] nums, int val) {

        int tempoIndex = 0;

        for (int i = 0; i < nums.length; i++) {

           if(nums[i] != val){
               nums[tempoIndex++] = nums[i];
           }

        }

        return tempoIndex;
    }
}
package leetcode;



public class RemoveDuplicatesFromSortedArray {


    public static void main(String[] args){

        int nums [] = {0,0,1,1,1,2,2,3,3,4};

        int nums2 [] = {1,1,2};

        System.out.println("New size: " + removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {


        int temp = 0;

        for (int i = 0; i < nums.length - 1; i++){

            if(!(nums[i] == nums[i+1])){

                nums[temp++] = nums[i];
            }

        }
        nums[temp++] = nums[nums.length - 1];



        for(int i = 0; i < temp; i++){

            System.out.println("New Array # : " + nums[i]);

        }




        return temp;

    }
}

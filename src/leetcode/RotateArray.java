package leetcode;

import java.util.Arrays;

/**
 * Created by vitalikuchynski on 5/26/20.
 */
public class RotateArray {

    public static void main(String[] args) {

        int [] origArray = {1,2,3,4,5,6,7};

        RotateArray rotateArray = new RotateArray();

        System.out.println(Arrays.toString(rotateArray.rotate(origArray,3)));

    }

    public int [] rotate(int[] nums, int k) {

        int sizeOfInputArr = nums.length;
        int [] reversedNums = new int [sizeOfInputArr];
         k = k % sizeOfInputArr;


        if (k < sizeOfInputArr && sizeOfInputArr != 0){

            for (int i = sizeOfInputArr - k , p = 0; i < sizeOfInputArr ; i++, p++ ){
                reversedNums[p] = nums[i];
            }

            for (int i = 0, p = k; i < sizeOfInputArr - k; i++, p++){
                reversedNums[p] = nums[i];
            }

            System.arraycopy(reversedNums, 0, nums,0, sizeOfInputArr);

        }

        return nums;
    }
}


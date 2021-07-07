package InterviewCamp;

import java.util.Arrays;

public class PartitioningArrayMoveZeroes {
//    You are given an array of integers.
//    Rearrange the array so that all zeroes are at the beginning of the array.
//For example, [4,2,0,1,0,3,0] -> [0,0,0,4,1,2,3]
// Time Complexity: O(n)
// Space Complexity: O(1)

    public static void main(String[] args) {

    int[] ints = {2,4,0,4,3,4,1,0};

        System.out.println(Arrays.toString(moveZeroesToTheEnd(ints)));

    }
    // partitioning from the end
    public static int[] moveZeroesToTheEnd(int[] ints) {

        int bound = ints.length - 1;

        for (int i = ints.length - 1; i >=0 ; i--) {

            if(ints[i] == 0){
                int temp = ints[bound];
                ints[bound] = ints[i];
                ints[i] = temp;
                bound--;
            }
        }
        return ints;
    }




    // partitioning from the beginning
    public static int[] moveZeroesToBeginning (int[] input) {

        int boundary = 0;

        for (int i = 0; i <= input.length - 1; i++) {

            if(input[i] == 0) {
               int tem = input[boundary];
               input[boundary] = input[i];
               input[i] = tem;
               boundary+= 1;
            }
        }
    return input;
    }

}

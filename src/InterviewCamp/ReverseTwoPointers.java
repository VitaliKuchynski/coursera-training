package InterviewCamp;

import java.util.Arrays;

public class ReverseTwoPointers {
//Video 1: (Level: Easy) Reverse the order of elements in an array.
// For example, A = [1,2,3,4,5,6], Output = [6,5,4,3,2,1]
    public static void main(String[] args) {

        int[] origArray = {0, 1, 2, 70, 11, 15, 7, 4};

        System.out.println(Arrays.toString(reverseAr(origArray)));
    }

    public static int[] reverseAr(int[] ints) {

        int start = 0, end = ints.length - 1;

        while(start < end){
            change(ints ,start, end);
            start++;
            end--;
        }
     return ints;
    }

    public static void change(int[] ints, int star, int end) {

        int tem = ints[star];
        ints[star] = ints[end];
        ints[end] = tem;

    }














    public static int[] reverse(int[] inputArray) {

        int start = 0, end = inputArray.length - 1;

        while (start < end) {
            swap(inputArray, start, end);
            start++;
            end--;
        }
        return inputArray;
    }

    public static void swap(int[] arrayInts, int start, int end) {

        int temp = arrayInts[start];
        arrayInts[start] = arrayInts [end];
        arrayInts [end] = temp;
    }
}

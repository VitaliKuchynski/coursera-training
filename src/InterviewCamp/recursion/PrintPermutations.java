package InterviewCamp.recursion;

import java.util.Arrays;

public class PrintPermutations {

    //Given an array of integers, print all permutation of size X.

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        printPerm(arr, 3);

    }

    public static void printPerm(int[] ints, int size) {

        if (ints == null || ints.length == 0 || size > ints.length) {
            return;
        }

        int[] buffer = new int[size];
        boolean [] isInBuffer = new boolean[ints.length];
        printPermutationHelper(ints,buffer, 0, isInBuffer);

    }

    public static void printPermutationHelper(int[] ints, int[] buffer, int bufferIndex, boolean[] isInBuffer) {


        //termination case - buffer is full
        if (bufferIndex == buffer.length) {
            System.out.println(Arrays.toString(buffer));
                return;
        }

        //find candidate that go into current buffer index
        for (int i = 0; i < ints.length; i++) {

            if (!isInBuffer[i]) {
                //place candidate into buffer index
                buffer[bufferIndex] = ints[i];
                isInBuffer[i] = true;

                //recurse to next buffer index
                printPermutationHelper(ints, buffer, bufferIndex + 1, isInBuffer);
                isInBuffer[i] = false;
            }

        }
    }






public static void printpermut(int[] a, int[] buffer, int bufIndex, boolean[] isInbuf) {

        if (bufIndex >= buffer.length) {
            System.out.println(Arrays.toString(buffer));
            return;
        }



    for (int i = 0; i < a.length; i++) {

        if (!isInbuf[i]) {

            buffer[bufIndex] = a[i];
            isInbuf[i] = true;

            printpermut(a, buffer, bufIndex + 1, isInbuf);
            isInbuf[i]= false;
        }

    }
}




















}

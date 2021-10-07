package InterviewCamp.recursion;

import java.util.Arrays;

public class PrintAllSubsetsArray {

//Level: Medium) Print all subsets of an array of integers.

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        printCombos(arr);

    }

    public static void printCombos(int[] ints) {

        if (ints == null || ints.length == 0) {
            return;
        }

        int[] buffer = new int[ints.length];
        printSubsetsArray(ints, buffer, 0, 0);


    }

    public static void printSubsetsArray(int[] ints, int[] buffer, int startIndex, int bufferIndex) {

        printArray(buffer, bufferIndex);

        // termination case buffer full
        if (bufferIndex == buffer.length) {
            return;
        }
        if (startIndex == ints.length){
            return;
        }

        // find candidates that go into current buffer index
        for (int i = startIndex; i < ints.length; i++) {
            // place item into buffer
            buffer[bufferIndex] = ints[i];

            // recurse to next buffer index
            printSubsetsArray(ints, buffer, i + 1, bufferIndex + 1);
        }
    }

    public static void printArray(int[] ints, int index) {

        int [] result = new int[index];

        if (index >= 0) System.arraycopy(ints, 0, result, 0, index);
        System.out.println(Arrays.toString(result));
    }


}

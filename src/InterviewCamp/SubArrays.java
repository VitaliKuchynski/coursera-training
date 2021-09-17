package InterviewCamp;

import java.util.Arrays;

public class SubArrays {

    public static void main(String[] args) {
        int[] newArr = {0, 4, 1, 2, 70, 11, 15, -1, -1, -1, -1};
        printSubsets(newArr);
    }
    public static void printSubsets(int[] a) {
        if (a == null || a.length == 0)
            return;
        int[] buffer = new int[a.length];
        printSubsetsHelper(a, buffer, 0, 0);
    }

    public static void printSubsetsHelper(int[] a, int[] buffer, int startIndex,int bufferIndex) {
        printArray(buffer, bufferIndex);

        if (bufferIndex == buffer.length) {
            return;
        }
        if (startIndex == a.length) {
            return;
        }

        for (int i = startIndex; i < a.length; i++) {
            // place item into buffer
            buffer[bufferIndex] = a[i];
            // recurse to next buffer index
            printSubsetsHelper(a, buffer, i + 1, bufferIndex + 1);
        }
    }

    public static void printArray(int[] a, int length) {
        int[] newArr = new int[length];

        for (int i = 0; i < length; i++) {
            newArr[i] = a[i];
        }

        System.out.println(Arrays.toString(newArr));
    }
}



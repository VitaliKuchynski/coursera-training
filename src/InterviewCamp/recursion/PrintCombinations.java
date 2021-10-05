package InterviewCamp.recursion;

import java.util.Arrays;

public class PrintCombinations {

    //Technique: Permutations/Combinations using Auxiliary Buffer

    // Medium
    //Given an array of integers, print all combinations of size X.

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        printCombos(arr, 3);

    }

    public static void printCombos(int[] ints, int x) {

        if (ints == null || ints.length == 0 || x > ints.length) {
            return;
        }

        int[] buffer = new int[x];
        printComboHelper(ints, buffer, 0, 0);


    }

    public static void printComboHelper(int[] ints, int[] buffer, int startIndex, int bufferIndex) {
        // termination case buffer full

        if (bufferIndex == buffer.length) {
            System.out.println(Arrays.toString(buffer));
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
            printComboHelper(ints, buffer, i + 1, bufferIndex + 1);
        }

    }


}

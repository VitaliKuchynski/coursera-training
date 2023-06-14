package InterviewCamp.heap;

import java.util.Collections;

import java.util.PriorityQueue;

public class BinaryTree {

    // Find k the smallest numbers in an array of integers.

    public static void main(String[] args) {

        int [] numbers = {6, 3, 6, 6, 2, 2, 4};
        printKSmallest(numbers, 4);

    }

    public static void printKSmallest(int[] numbers, int k) {

        if (k > numbers.length) {
            throw new IllegalArgumentException();
        }

        // In java PriorityQueue class is a heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < numbers.length; i++) {
            if (i < k) {
                heap.add(numbers[i]);
            } else if (numbers[i] < heap.peek()) {
                heap.remove();
                heap.add(numbers[i]);
            }
        }

        for (Integer integer : heap) {
            System.out.println(integer);
        }
    }
}

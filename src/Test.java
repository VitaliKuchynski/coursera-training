import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {

        int[] input = new int[] {1,2,3,4, 2};

//        printStars(7);
        lookFor(input);


    }

    public static void lookFor(int []ar) {

        int[] result = new int[ar.length];

        getSum(ar, 0, result);

        System.out.println(Arrays.toString(result));

    }

    public static void getSum(int[] ar, int index, int[] result) {

        if (index == ar.length ) {
            return;
        }

        int currentSum = 1;

        for (int i = 0; i < ar.length; i++) {

            if (i != index) {
            currentSum *= ar[i];
            }
        }
        result[index] = currentSum;
        getSum(ar, index + 1, result);


    }


    public static int lookForLargest(int[] ints) {

        if (ints.length == 0 || ints == null) {
            return -1;
        }

        int largestSoFar = ints[0];

        for (int i = 1; i < ints.length - 1; i++) {

            if (ints[i] > largestSoFar) {
                largestSoFar = ints[i];
            }
        }
        return largestSoFar;
    }


    public static void printStars(int numberOfStars) {

        char star = '*';

        for (int i = 0; i <= numberOfStars; i++) {

            System.out.println(star);

            for (int j = 0; j <= i + 1; j++) {

                System.out.print(star);
            }

        }
    }








    public void findKSmallest(int[] ar, int target) {


        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < ar.length - 1; i++) {

            if (i < target) {
                queue.add(ar[i]);
            } else if (ar[i] < queue.peek()) {
                queue.remove();
                queue.add(ar[i]);

            }

        }
    }



















}

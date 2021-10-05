public class Test {


    public static void main(String[] args) {

        int[] input = new int[] {2,4,5,19, 1};

        printStars(7);


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

}

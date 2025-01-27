package InterviewCamp.arrays;

public class FindSecondLargest {

    public int findSecondLargest(int [] arr) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int current: arr) {

            if (current > largest) {
                secondLargest = largest;
                largest = current;

            } else if (current > secondLargest && current != largest) {
                secondLargest = current;
            }

        }

        return secondLargest;

    }
}

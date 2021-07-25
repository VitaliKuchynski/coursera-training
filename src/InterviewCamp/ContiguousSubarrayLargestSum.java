package InterviewCamp;


//Level: Medium Given an array of integers that can be both +ve and -ve,
// find the contiguous subarray with the largest sum

public class ContiguousSubarrayLargestSum {

    public static void main (String[] args) {

        int [] inputInts = {1, 2, -3, -2, 5, 1};

        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(inputInts));
    }

    static int maxSubArraySum(int ints[]) {

    int result = ints[0], maxEnding = ints[0];

        for (int i = 1; i < ints.length; i++) {
            maxEnding = Math.max(ints[i], maxEnding + ints[i]);
            result = Math.max(result, maxEnding);
        }
        return result;
    }
}

package InterviewCamp.queue;

import java.util.LinkedList;
import java.util.Queue;
//Level: Easy Given an array of integers A, find the sum of each sliding window of size K
public class QueueSlidingWindowSum {

    public static void main(String[] args) {
        int[] ar = new int[] {1, 2, 4, 5, 6, 7, 5, 3};

        slidingWinSum(ar, 3);
    }

    public static void slidingWinSum(int[] a, int widSize) {
        if (a == null || widSize == 0 || a.length == 0) {
           // return  or throw an error
        }

        Queue<Integer> q = new LinkedList<>();

        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (q.size() == widSize) {
                int last = q.remove();
                sum -= last;
            }
            q.add(a[i]);
            sum += a[i];
            if (q.size() == widSize) {
                System.out.println(sum);
            }
        }
    }
}

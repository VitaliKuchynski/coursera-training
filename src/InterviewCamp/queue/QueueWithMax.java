package InterviewCamp.queue;

import InterviewCamp.stack.EmptyQueueException;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


//Level: Hard Implement a Queue with O(1) lookup of the Maximum element.
public class QueueWithMax {

    Queue<Integer> main;
    Deque<Integer> max;

    public QueueWithMax() {
        this.main = new LinkedList<>();
        this.max = new LinkedList<>();
    }

    public void enqueue(int item) {
        main.add(item);

        while (!max.isEmpty() && max.getLast() < item) {
            max.removeLast();
        }
        max.add(item);
    }

    public void dequeue() throws EmptyQueueException {
        if (main.isEmpty()) {
            throw new EmptyQueueException();
        }
        int item = main.remove();
        if (max.getFirst() == item) {
            max.remove();
        }
    }

    public int findMax() throws EmptyQueueException {
        if (max.isEmpty()) {
            throw new EmptyQueueException();
        }
        return max.getFirst();
    }

    public static void main(String[] args) throws EmptyQueueException {
        QueueWithMax queueWithMax = new QueueWithMax();
        queueWithMax.enqueue(1);
        queueWithMax.enqueue(34);
        queueWithMax.enqueue(17);
        queueWithMax.enqueue(3);
        queueWithMax.dequeue();
        queueWithMax.dequeue();
        queueWithMax.dequeue();

        System.out.println(queueWithMax.findMax());

        System.out.println("------- Maximum of Sliding Window ");

        int[] a = { 4, 6, 5, 2, 4, 7 };
        int window = 3;
        slidingWindowMax(a, window);

    }

    // Level: Hard Maximum of Sliding Window:
    // Given an array A and an integer K, find the maximum element in each sliding window of size K
    public static void slidingWindowMax(int[] a, int windowSize) {

        if (a == null || a.length == 0 || windowSize <=0) {
            return;
        }

        QueueWithMax queueWithMax = new QueueWithMax();

        try {
            // add first K elements
            for (int i = 0; i < windowSize; i++) {
                queueWithMax.enqueue(a[i]);
            }
            System.out.println(queueWithMax.findMax());

            // add the rest one by one
            for (int i = windowSize; i < a.length; i++) {
                queueWithMax.dequeue();
                queueWithMax.enqueue(a[i]);
                System.out.println(queueWithMax.findMax());
            }

        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }
    }
}

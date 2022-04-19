package InterviewCamp.queue;

import InterviewCamp.stack.EmptyQueueException;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
}

package InterviewCamp.queue;

import InterviewCamp.stack.EmptyQueueException;

public class Queue {
    int[] a;

    int front;
    int back;
    int length;

    public Queue(int capacity) {
        a = new int[capacity];
        front = 0;
        back = 0;
        length = 0;
    }

    public void add(int item) throws QueueFullException {
        if (length == a.length) {
            throw new QueueFullException();
        }
        a[back] = item;
        back = (back + 1) % a.length;
        length++;
    }

    public int remove() throws EmptyQueueException {
        if (length == 0) {
            throw new EmptyQueueException();
        }
        int result = a[front];
        front = front + 1 % a.length;
        length--;
        return result;
    }


    public static void main(String[] args) throws QueueFullException, EmptyQueueException {


        Queue queue = new Queue(2);
        queue.add(1);
        queue.add(2);

        System.out.println(queue.remove());

    }

}

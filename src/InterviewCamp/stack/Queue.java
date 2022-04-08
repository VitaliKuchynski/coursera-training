package InterviewCamp.stack;

import java.util.Stack;

public class Queue<A> {

    Stack<A> s1;
    Stack<A> s2;

    public Queue() {
        s1 = new Stack<A>();
        s2 = new Stack<A>();
    }

    public void enqueue(A a) {
        s1.push(a);
    }

    public A dequeue() throws EmptyQueueException {

        if (s2.isEmpty()){
            flushToS2();
        }

        if (s2.isEmpty()){
            throw new EmptyQueueException();
        }
        return s2.pop();
    }

    private void flushToS2() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public static void main(String[] args) throws EmptyQueueException {

        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue());
     }

}

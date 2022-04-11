package InterviewCamp.stack;

import java.util.EmptyStackException;
import java.util.Stack;


//Implement a Stack with a max() function.
//This function runs in O(1) time and returns the value of the maximum number on the stack.
public class StackWithMax {
    Stack<Integer> main;
    Stack<Integer> max;

    public StackWithMax() {
        main = new Stack<>();
        max = new Stack<>();
    }

    public void push(int a) {
        main.push(a);
        if (max.isEmpty() || a >= max.peek()){
            max.push(a);
        }
    }

    public int max() {
        if (max.isEmpty()) {
            throw new EmptyStackException();
        }
      return max.peek();
    }

    public int pop() {
        if (max.isEmpty()) {
            throw new EmptyStackException();
        }
        int item = main.pop();
        if (max.peek() == item) {
            max.pop();
        }
        return item;
    }
}

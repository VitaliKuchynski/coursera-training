package InterviewCamp.stack;

import java.util.Stack;

//Level: Easy Find if a given number N exists in a stack S
//traversing a stack technique
public class StackReverse {

    public static boolean find(int target, Stack<Integer> s) {

        if (s == null) {
            return false;
        }

        Stack<Integer> temp = new Stack<>();
        boolean found = false;

        while (!s.isEmpty()) {
            if (s.peek() == target) {
                found = true;
                break;
            }
            temp.push(s.pop());
        }

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
        return found;
    }

    public static void main(String[] args) {

        Stack<Integer> stackTo = new Stack<>();
        stackTo.push(1);
        stackTo.push(4);
        stackTo.push(5);
        stackTo.push(6);
        stackTo.push(8);
        stackTo.push(2);

        System.out.println(find(8, stackTo));
    }
}

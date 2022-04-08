package InterviewCamp.stack;

public class ArrayStack {
    int[] a;

    int s1;
    int s2;

    public ArrayStack(int arraySize) {
        a = new int[arraySize];
        s1 = 0;
        s2 = a.length - 1;
    }

    public void push(int stackNumber, int item) throws StackEmptyException {

        if (stackNumber != 1 && stackNumber != 2) {
            throw new IllegalArgumentException("Invalid stack number.");
        }

        if (s1 > s2) {
            throw new StackEmptyException();
        }
        if (stackNumber == 1) {
            a[s1++] = item;
        } else {
            a[s2--] = item;
        }
    }

    public int pop(int stackNumber) throws StackEmptyException {

        if (stackNumber != 1 && stackNumber != 2) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        if (stackNumber == 1 && s1 > 0) {
            return a[--s1];
        }
        else if (stackNumber == 2 && s2 < a.length - 1) {
            return a[++s2];
        }
        throw new StackEmptyException();
    }
}

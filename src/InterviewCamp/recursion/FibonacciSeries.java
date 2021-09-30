package InterviewCamp.recursion;

import java.util.HashMap;

public class FibonacciSeries {

    public static void main(String[] args) {

        fibonacci(3);

    }

    public static int findNthElementFibonacci(int number) {


        if (number == 1 || number == 2) {
            return 1;
        }

        int i = findNthElementFibonacci(number - 1) + findNthElementFibonacci(number - 2);

        System.out.println("i ----- " + i);
        return i;

    }

    public static int fibonacci(int n) {
        return fibonacci(n, new HashMap<Integer, Integer>());
    }

    public static int fibonacci(int n, HashMap<Integer, Integer> memo) {

        if (n == 1 || n == 2)
        return 1;

    if (memo.containsKey(n)) // lookup memo
          return memo.get(n);

        int result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);

        System.out.println(n + "  " + result);
        memo.put(n, result); // insert memo
        System.out.println(memo.toString());
        return result;
    }
}

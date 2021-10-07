package InterviewCamp.recursion;

import java.util.Stack;

public class CoinChange {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        printCoins(arr, 3);

    }

    public static void printCoins(int[] coins, int target) {

        if (coins == null || coins.length == 0 || target > coins.length) {
            return;
        }

        printCoinsHelper(coins, target, 0, new Stack<>(), 0);

    }

    public static void printCoinsHelper(int[] coins, int target, int startIndex, Stack<Integer> buffer, int sum) {

        //termination case
        if (sum > target) {
            return;
        }
        if (sum == target) {
            System.out.println(buffer);
            return;
        }

        //find candidate that go into buffer
        for (int i = startIndex; i < coins.length; i++) {
            //place candidate into buffer and recurse

            buffer.push(coins[i]);
            printCoinsHelper(coins, target, i, buffer , sum + coins[i]);
            buffer.pop();
        }
    }
}
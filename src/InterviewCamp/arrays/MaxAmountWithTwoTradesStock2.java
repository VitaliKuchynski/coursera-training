package InterviewCamp.arrays;

import java.util.Arrays;

//Level: Hard Given a list of stock prices for a company,
// find the maximum amount of money you can make with two trades. A trade is a buy and sell.
// The two trades cannot overlap

public class MaxAmountWithTwoTradesStock2 {

    public static void main(String[] args) {

        int[] stock = new int[] {3,3,5,0,0,3,1,4};

        System.out.println(twoTrades(stock));
    }

    public static Integer twoTrades(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] bestTill = new int[prices.length];
        int minSoFar = Integer.MAX_VALUE;
        int maxDiff = 0;

        for (int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            maxDiff = Math.max(maxDiff, prices[i] - minSoFar);
            bestTill[i] = maxDiff;
        }

        int[] bestFrom = new int[prices.length];
        int maxSoFar = Integer.MIN_VALUE;
        int maxDif = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, prices[i]);
            maxDif = Math.max(maxDif, maxSoFar - prices[i]);
            bestFrom[i] = maxDif;
        }

        int maxTwoTrades = 0;

        for (int i = 0; i < prices.length; i++) {

            int maxSecondTrades = (i + 1 < prices.length) ? bestFrom[i + 1] : 0;

            maxTwoTrades = Math.max(maxTwoTrades, bestTill[i] + maxSecondTrades);

        }
        return maxTwoTrades;
    }
}

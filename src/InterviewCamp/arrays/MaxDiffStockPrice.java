package InterviewCamp.arrays;

public class MaxDiffStockPrice {

//Level: Medium
// Given a list of stock prices for a company, find the maximum amount of money you can make with one trade.
// A trade is a buy and sell.
    public static void main(String[] args) {
        int[] stock = new int[] {11, 3,4, 5,67,23, 69, 24};
        int[] stockNeg = new int[] {11, 10,6, 5,3,1};
        System.out.println(maxDifference(stockNeg));
    }

    public static int maxDifference(int[] stock) {

        if (stock == null || stock.length == 0) {
            return 0;
        }

        int minSoFar = Integer.MAX_VALUE;
        int maxTrade = 0;

        for (int i = 0; i < stock.length ; i++) {

            minSoFar = Math.min(stock[i], minSoFar);
            int maxAtI = stock[i] - minSoFar;

            if (maxAtI > maxTrade) {
                maxTrade = maxAtI;
            }
        }
        return maxTrade;
    }
}

package leetcode;

/**
 * Created by vitalikuchynski on 6/5/20.
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
                  //0  1  2  3  4  5
    int[] prices = {7, 1, 5, 3, 6, 4};
    int[] price2 = {2, 2, 3, 4, 5};


    System.out.println(maxProfit(price2));

    }

    public static int maxProfit(int[] prices) {

        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int j = i + 1;
//            for (int j = i + 1 ; j < prices.length; j++) {
//
//                if(prices[i] > prices[j]){
//                    break;
//                }

                if(prices[i] <= prices[j]){
                    profit += prices[j] - prices[i];
                    //break;
                }
            }
        //}
        return profit;
    }


}

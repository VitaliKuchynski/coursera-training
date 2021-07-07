package leetcode;

/**
 * Created by vitalikuchynski on 6/3/20.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
                      //0  1  2  3  4  5
        int[] prices = {2, 6, 1, 7, 3, 4};
        int[] price2 = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {

        int profit = 0;

        int pointer1 = prices.length - 1;

        int pointer2 = prices.length - 2;



        while(pointer1 >= 0 && pointer2 >= 0){

            if(prices[pointer1] > prices[pointer2]) {
                if(prices[pointer1] - prices[pointer2] > profit){
                profit = prices[pointer1] - prices[pointer2];
                }
                pointer2--;
            }

            else {
               pointer1 = pointer2;
               pointer2--;
            }

        }

        return profit;
    }

}
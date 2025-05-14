package practisequestions.leetcode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/*
You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.

You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.

Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.

Example 1:

Input: prices = [10,1,5,6,7,1]

Output: 6
Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.

Example 2:

Input: prices = [10,8,7,5,2]

Output: 0
Explanation: No profitable transactions can be made, thus the max profit is 0.

*
* */
public class BestTradeStock {
    public static void main(String[] args) {
        System.out.println(streamApproach());

    }

    public static int normalApproach() {
        //        int[] prices = {10,1,5,6,7,1};
        int[] prices = {10, 8, 7, 5, 2};
        // keep the min price
        int minPrice = Integer.MAX_VALUE;
        //keep the max profit..
        int maxProfit = 0;

        for (int price : prices) {
            //if the price is lesser than min set the  min it is buy
            if (price < minPrice) {
                minPrice = price;
            } else {
                //here we are adding in the else block because if the price is less than the minPrice then there will be no profit instead loss.......
                //calculate the profit which is currentPrice - minPrice = profit
                //if profit > maxProfit set maxProfit = profit and return the maxProfit...............
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        System.out.println("Max Profit is " + maxProfit);
        return minPrice;
    }

    public static int streamApproach(){
        int[] prices = {10,1,5,6,7,1};
        AtomicInteger minPrice = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger maxProfit = new AtomicInteger(0);

        Arrays.stream(prices).forEach(price -> {
            minPrice.set(Math.min(price, minPrice.get()));
            maxProfit.set(Math.max(maxProfit.get(), price - minPrice.get()));
        });
        return maxProfit.get();
    }
}

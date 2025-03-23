package practisequestions;

/**
 * You are given an array of integers, prices where prices[i] is the price of a given stock on an ith day. You want
 * to maximise the profit by choosing a single day to buy one stock and a different day to sell that stock. Return
 * the maximum profit you can get from this transaction.
 * Input : prices = [7, 1, 5, 4, 3, 6]
 * Output : 5
 */

public class StockMaxProfit {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 4, 3, 6};
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profit;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            profit = price - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        System.out.println("Profit is: " + maxProfit);
    }
}

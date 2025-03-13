package john;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Problem Breakdown:
 * John has a truck that can carry at most M items.
 * There are N items available at the sale.
 * Some items have a negative price, meaning the seller is willing to pay John to take them away (junk items).
 * Some items have a positive price, meaning John would have to pay to take them (not useful to John).
 * John's goal is to maximize the money he can earn, meaning he should take up to M items with the lowest (most negative) prices.
 * <p>
 * Input Format:
 * The first line contains an integer M (the maximum items John can carry).
 * The second line contains an integer N (the total number of available items).
 * The third line contains N space-separated integers representing the prices of the items.
 * <p>
 * Output Format:
 * Print the maximum amount of money John can earn.
 **/

public class JohnMaxProfit {


    public void computeMaxProfit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the total number of items in garage");
        int N = scanner.nextInt();

        System.out.println("Enter the total Capacity of John");
        int M = scanner.nextInt();

        ArrayList<Integer> negativePrices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            System.out.println("Enter the price for the " + i + " item");
            int price = scanner.nextInt();
            if (price < 0) {
                negativePrices.add(price);
            }
        }

        int maxProfit = negativePrices.stream()
                .sorted()
                .limit(M)
                .mapToInt(Math::abs)
                .sum();

        System.out.println("Max profit that the john earn is :" + maxProfit);
    }

    public static void main(String[] args) {
        new JohnMaxProfit().computeMaxProfit();
    }
}

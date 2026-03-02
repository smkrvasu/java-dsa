package com.smkrvasu.algomaster.arrays;

public class BuySellStockII {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    // Invariant: Sum of all positive difference
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}

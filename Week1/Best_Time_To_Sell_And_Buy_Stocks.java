import java.util.*;

public class Best_Time_To_Sell_And_Buy_Stocks {

    // Brute Force
    // TC: O(N^2), SC: O(1)
    public int maxProfitBrute(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    // Optimized (Single Pass)
    // TC: O(N), SC: O(1)
    public int maxProfitOptimized(int[] prices) {
        int buy = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                max = Math.max(max, prices[i] - buy);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Best_Time_To_Sell_And_Buy_Stocks solution = new Best_Time_To_Sell_And_Buy_Stocks();
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Brute Profit: " + solution.maxProfitBrute(prices));
        System.out.println("Optimized Profit: " + solution.maxProfitOptimized(prices));
    }
}
package com.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        // dp[i] will store the minimum coins needed for amount i
        int[] dp = new int[amount + 1];

        // Fill array with a value larger than any possible solution
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins needed for amount 0
        dp[0] = 0;

        // Step 1: Iterate through all amounts from 1 to 'amount'
        for (int i = 1; i <= amount; i++) {
            // Step 2: Try every available coin
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // Step 3: If target is still unreachable, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum coins needed: " + coinChange(coins, amount));
        // Expected Output: 3
    }
}
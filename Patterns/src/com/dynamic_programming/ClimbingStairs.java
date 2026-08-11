package com.dynamic_programming;

import java.util.Arrays;

public class ClimbingStairs {

	public static void main(String[] args) {
//		System.out.println("Ways to climb 5 stairs: " + climbStairsrecursive(5)); // Output: 8
//		System.out.println("Ways to climb 5 stairs: " + climbStairs(5)); // Output: 8
		System.out.println("Ways to climb 5 stairs: " + climbStairsmemoization(5)); // Output: 8
	}

	private static int climbStairsmemoization(int n) {
		int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // Initialize cache with -1 (meaning uncalculated)
        return helper(n, memo);
	}
	
	private static int helper(int n, int[] memo) {
        // Base cases
        if (n <= 1) return 1;
        if (n == 2) return 2;

        // Step 1: Return cached answer if already computed
        if (memo[n] != -1) {
            return memo[n];
        }

        // Step 2: Compute and store in cache before returning
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }

	private static int climbStairsrecursive(int n) {

		if(n<=1) return 1;
		if(n==1) return 2;
		
		return climbStairsrecursive(n-1) + climbStairsrecursive(n-2);
	}

	private static int climbStairs(int n) {

		if(n<=2) {
			return n;
		}
		
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
}

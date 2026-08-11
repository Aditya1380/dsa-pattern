package com.dynamic_programming;

public class HouseRobber {

    public static int rob(int[] nums) {
        // Edge cases
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // rob1 represents dp[i - 2]
        // rob2 represents dp[i - 1]
        int rob1 = 0;
        int rob2 = 0;

        // Iterate through every house
        for (int num : nums) {
            // current represents dp[i] = max(rob house + dp[i-2], skip house + dp[i-1])
            int current = Math.max(num + rob1, rob2);
            
            // Shift the window forward for the next iteration
            rob1 = rob2;
            rob2 = current;
        }

        return rob2; // By the end, rob2 holds the max profit for the entire street
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Maximum money robbed: " + rob(nums));
        // Expected Output: 12
    }
}
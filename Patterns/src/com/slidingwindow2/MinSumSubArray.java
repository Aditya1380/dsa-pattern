package com.slidingwindow2;

public class MinSumSubArray {

	public static int findMinSubArray(int[] nums, int k) {
		int windowSum = 0;

		for (int i = 0; i < k; i++) {
			windowSum += nums[i];
		}

		int minSum = windowSum;

		for (int i = k; i < nums.length; i++) {
			windowSum += nums[i] - nums[i - k];
			minSum = Math.min(minSum, windowSum);
		}
		return minSum;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		System.out.println("Minimum Sum: " + findMinSubArray(nums, k));
	}
}

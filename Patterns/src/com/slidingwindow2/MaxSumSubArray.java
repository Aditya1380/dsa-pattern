package com.slidingwindow2;

public class MaxSumSubArray {

	public static int findMaxSubArray(int[] nums, int k) {
		int windowSum = 0;

		for (int i = 0; i < k; i++) {
			windowSum += nums[i];
		}

		int maxSum = windowSum;

		for (int i = k; i < nums.length; i++) {
			windowSum += nums[i] - nums[i - k];
			maxSum = Math.max(maxSum, windowSum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		System.out.println("Maximum Sum: " + findMaxSubArray(nums, k));
	}
}

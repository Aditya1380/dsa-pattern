package com.twopointers1;

public class TwoSum2 {

	public static int[] twosum(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		int sum = 0;

		while (left < right) {
			sum = nums[left] + nums[right];

			if (sum == target) {
				return new int[] { left + 1, right + 1 };
			} else if (sum > target) {
				right--;
			} else {
				left++;
			}
		}

		return new int[] { -1, -1 };
	}

	
	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int[] result = twosum(nums, 6);
		
		for (int num : result) {
			System.out.print(num+" ");
		}
	}
}

package com.twopointers1;

public class RemoveDuplicates {

	public static void removedup(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == nums[i + 1]) {
				nums[i] = nums[i+1];
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 4 };

		removedup(nums);
		
		System.out.println(java.util.Arrays.toString(nums));
	}
}

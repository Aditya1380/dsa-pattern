package com.cyclicsort3;

public class MissingNumber {

	public static int findMissingNumber(int[] nums) {
		int i = 0;
		int n = nums.length;

		while (i < n) {
			int correctIndex = nums[i];

			if (nums[i] < n && nums[i] != nums[correctIndex]) {
				swap(nums, i, correctIndex);
			} else {
				i++;
			}
		}

		for (int index = 0; index < n; index++) {
			if (nums[index] != index) {
				return index;
			}
		}
		return n;
	}

	private static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

	public static void main(String[] args) {
		int[] nums1 = { 3, 0, 1 };
//        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};

		System.out.println("Missing number in [3, 0, 1]: " + findMissingNumber(nums1)); // Output: 2
//        System.out.println("Missing number in [9, 6, 4, ...]: " + findMissingNumber(nums2)); // Output: 8
	}
}

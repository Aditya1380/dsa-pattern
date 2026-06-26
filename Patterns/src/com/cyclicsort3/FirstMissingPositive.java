package com.cyclicsort3;

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] nums1 = { 3, 4, -1, 1 };
		int[] nums2 = { 1, 2, 0 };
		int[] nums3 = { 7, 8, 9, 11, 12 };

		System.out.println("First missing positive: " + findFirstMissingPositive(nums1)); // Output: 2
		System.out.println("First missing positive: " + findFirstMissingPositive(nums2)); // Output: 3
		System.out.println("First missing positive: " + findFirstMissingPositive(nums3)); // Output: 1
	}

	private static int findFirstMissingPositive(int[] nums) {

		int i = 0;
		int n = nums.length;

		while (i < n) {
			if (nums[i] > 0 && nums[i] <= n) {
				int correctedIndex = nums[i] - 1;
				if (nums[i] != nums[correctedIndex]) {
					swap(nums, i, correctedIndex);
				} else {
					i++;
				}
			} else {
				i++;
			}
		}

		for (int index = 0; index < n; index++) {
			if (nums[index] != index + 1) {
				return index + 1;
			}
		}
		return n + 1;
	}

	private static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;

	}
}

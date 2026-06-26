package com.cyclicsort3;

public class FindDuplicateCyclicSort {
	public static int findDuplicate(int[] nums) {
		int i = 0;
		int n = nums.length;

		// Step 1: Cyclic Sort
		while (i < n) {
			// Check if the current number is already at its correct index
			if (nums[i] != i + 1) {
				int correctIndex = nums[i] - 1;

				// If the number at the correct index is different, swap them
				if (nums[i] != nums[correctIndex]) {
					swap(nums, i, correctIndex);
				} else {
					// If the number at the correct index is the same,
					// we found our duplicate!
					return nums[i];
				}
			} else {
				// Move forward if the number is already in its correct place
				i++;
			}
		}

		return -1; // Fallback if no duplicate exists
	}

	private static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 4, 2, 2 };
		int[] nums2 = { 3, 1, 3, 4, 2 };

//		System.out.println("Duplicate in [1, 3, 4, 2, 2]: " + findDuplicate(nums1)); // Output: 2
		System.out.println("Duplicate in [3, 1, 3, 4, 2]: " + findDuplicate(nums2)); // Output: 3
	}
}

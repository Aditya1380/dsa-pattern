package com.cyclicsort3;

public class SingleNumberCyclic {
	public static int findSingleNumber(int[] nums) {
		int i = 0;
		int n = nums.length;

		// Step 1: Cyclic Sort
		while (i < n) {
			// Out-of-bounds check (if elements can exceed array index limits)
			if (nums[i] > 0 && nums[i] <= n) {
				int correctIndex = nums[i] - 1;

				// Swap if the number is not at its correct position
				if (nums[i] != nums[correctIndex]) {
					swap(nums, i, correctIndex);
				} else {
					i++;
				}
			} else {
				i++;
			}
		}

		// Step 2: Find the mismatch
		// The single number will be sitting at an index where nums[index] != index + 1
		for (int index = 0; index < n; index++) {
			if (nums[index] != index + 1) {
				// If it's a duplicate pair, one of them will occupy the correct index,
				
				// and the other will be pushed to a mismatched index.
				return nums[index];
			}
		}

		return -1; // Fallback
	}

	private static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

	public static void main(String[] args) {
		// Range 1 to 4. 2 appears once, others appear twice.
		int[] nums = { 4, 1, 3, 1, 3, 4, 2 };
		System.out.println("The single number is: " + findSingleNumber(nums)); // Output: 2
	}
}

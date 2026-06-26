package com.cyclicsort3;

public class DuplicateAndMissing {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 3, 5 }; // 3 is duplicated, 4 is missing
		int[] result = findDuplicateAndMissing(nums);

		System.out.println("Duplicate Number: " + result[0]); // Output: 3
		System.out.println("Missing Number: " + result[1]); // Output: 4
	}

	private static int[] findDuplicateAndMissing(int[] nums) {

		int i = 0;
		int n = nums.length;

		while (i < n) {
			int correctedIndex = nums[i] - 1;
			if (nums[i] != nums[correctedIndex]) {
				swap(nums, i, correctedIndex);
			} else {
				i++;
			}
		}

		for (int index = 0; index < n; index++) {
			if (nums[index] != index + 1) {
				return new int[] { nums[index], index + 1 };
			}
		}

		return new int[] { -1, -1 };
	}

	private static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}
}

package com.binary_search4;

public class FindInMountainArray {

	public static void main(String[] args) {
		int[] mountain = { 1, 2, 3, 4, 5, 3, 1 };

		System.out.println("Index of 3: " + findInMountainArray(3, mountain)); // Output: 2 (Index 2 is chosen over
																				// index 5 because it's smaller)
		System.out.println("Index of 0: " + findInMountainArray(0, mountain)); // Output: -1 (Not found)
	}

	private static int findInMountainArray(int target, int[] nums) {

		int peak = findPeakMountain(nums);

		int leftSide = findtargetInAcesdingSideOfArray(nums, target, 0, peak);
		if (leftSide != -1) {
			return leftSide;
		}
		return findtargetInDesdingSideOfArray(nums, target, peak + 1, nums.length-1);
	}

	private static int findtargetInDesdingSideOfArray(int[] nums, int target, int low, int high) {
		while(low<high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	private static int findtargetInAcesdingSideOfArray(int[] nums, int target, int low, int high) {
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	private static int findPeakMountain(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < nums[mid + 1]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}

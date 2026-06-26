package com.binary_search4;

public class MinimumInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums1 = { 3, 4, 5, 1, 2 };
		int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
		int[] nums3 = { 11, 13, 15, 17 };

//		System.out.println("Minimum in [3, 4, 5, 1, 2]: " + findMin(nums1)); // Output: 1
//		System.out.println("Minimum in [4, 5, 6, 7, 0, 1, 2]: " + findMin(nums2)); // Output: 0
		System.out.println("Minimum in [11, 13, 15, 17]: " + findMin(nums3)); // Output: 11
	}

	private static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return nums[low];
	}
}

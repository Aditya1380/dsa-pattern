package com.binary_search4;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };

		System.out.println("Insert 5: " + searchInsert(nums, 5)); // Output: 2 (Found at index 2)
		System.out.println("Insert 2: " + searchInsert(nums, 2)); // Output: 1 (Not found, should be at index 1)
		System.out.println("Insert 7: " + searchInsert(nums, 7)); // Output: 4 (Not found, should be at index 4)
		System.out.println("Insert 0: " + searchInsert(nums, 0)); // Output: 0 (Not found, should be at index 0)
	}

	private static int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[mid]<target) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
			
		}

		return low;
	}
}

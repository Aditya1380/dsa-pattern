package com.binary_search4;

public class BinarySearch {

	public static void main(String[] args) {

//		int nums[] = { 1, 2, 5, 6, 7, 8, 9, 10 };
//		System.out.println("target is at index position :" + findthetarget(nums, 7));

		int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;
        int result = findthetarget(arr, target);
        
        System.out.println("Index of target: " + result); 
	}

	private static int findthetarget(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			
			int mid = low + (high - low) / 2;
			
			if (target == nums[mid]) {
				return mid;
			}

			if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}
}

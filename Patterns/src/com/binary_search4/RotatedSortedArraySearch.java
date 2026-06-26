package com.binary_search4;

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println("Index of 0: " + search(nums, 0)); // Output: 4
		System.out.println("Index of 3: " + search(nums, 3)); // Output: -1 (Not found)
		System.out.println("Index of 4: " + search(nums, 4)); // Output: 0
	}
	public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if(nums[mid]==target) {
				return mid;
			}
			
			if (nums[low] <= nums[mid]) {
                // Check if target lies within the sorted left boundaries
                if (target >= nums[low] && target < nums[mid]) {
                     high = mid - 1; // Look left
                } else {
                    low = mid + 1;  // Look right
                }
            } 
            // Case 3: Otherwise, the right half must be sorted
            else {
                // Check if target lies within the sorted right boundaries
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;  // Look right
                } else {
                    high = mid - 1; // Look left
                }
            }
        }

        // Target not found
        return -1;
    }

}

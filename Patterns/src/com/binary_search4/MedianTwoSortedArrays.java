package com.binary_search4;

public class MedianTwoSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// Ensure nums1 is the smaller array to optimize binary search time complexity
		// to O(log(min(m,n)))
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;

		while (low <= high) {
			// Partition points
			int partitionX = low + (high - low) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			// If partitionX is 0, nothing is on the left side of nums1. Use -INF
			// If partitionX is x, nothing is on the right side of nums1. Use +INF
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

			// Same handling for nums2
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

			// Check if we found the correct partition
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// If the total number of elements is odd
				if ((x + y) % 2 != 0) {
					return Math.max(maxLeftX, maxLeftY);
				}
				// If the total number of elements is even
				else {
					return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
				}
			}
			// We are too far right in nums1, need to move partitionX left
			else if (maxLeftX > minRightY) {
				high = partitionX - 1;
			}
			// We are too far left in nums1, need to move partitionX right
			else {
				low = partitionX + 1;
			}
		}

		throw new IllegalArgumentException("Input arrays are not sorted correctly.");
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		System.out.println("Median of [1,3] and [2]: " + findMedianSortedArrays(nums1, nums2));
		// Output: 2.0 (Merged: [1, 2, 3] -> Median: 2)

		int[] nums3 = { 1, 2 };
		int[] nums4 = { 3, 4 };
		System.out.println("Median of [1,2] and [3,4]: " + findMedianSortedArrays(nums3, nums4));
		// Output: 2.5 (Merged: [1, 2, 3, 4] -> Median: (2 + 3) / 2 = 2.5)
	}
}
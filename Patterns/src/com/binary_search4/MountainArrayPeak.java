package com.binary_search4;

public class MountainArrayPeak {
	public static void main(String[] args) {
		int[] mountain1 = { 0, 1, 0 };
		int[] mountain2 = { 0, 2, 1, 0 };
		int[] mountain3 = { 0, 10, 5, 2 };
		int[] mountain4 = { 3, 4, 5, 1 };

		System.out.println("Peak index for [0, 1, 0]: " + peakIndexInMountainArray(mountain1));
		System.out.println("Peak index for [0, 2, 1, 0]: " + peakIndexInMountainArray(mountain2));
		System.out.println("Peak index for [0, 10, 5, 2]: " + peakIndexInMountainArray(mountain3));
		System.out.println("Peak index for [3, 4, 5, 1]: " + peakIndexInMountainArray(mountain4));
	}

	private static int peakIndexInMountainArray(int[] nums) {
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
		return nums[low];
	}
}

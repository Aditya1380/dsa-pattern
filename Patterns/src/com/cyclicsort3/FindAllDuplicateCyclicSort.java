package com.cyclicsort3;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateCyclicSort {
	public static List<Integer> findDuplicatesTwoPass(int[] nums) {
	    int i = 0;
	    int n = nums.length;
	    List<Integer> duplicates = new ArrayList<>();

	    // Step 1: Pure Cyclic Sort (No adding to list here)
	    while (i < n) {
	        int correctIndex = nums[i] - 1;
	        if (nums[i] != nums[correctIndex]) {
	            swap(nums, i, correctIndex);
	        } else {
	            i++;
	        }
	    }

	    // Step 2: Single scan to find all mismatches
	    for (int index = 0; index < n; index++) {
	        if (nums[index] != index + 1) {
	            duplicates.add(nums[index]);
	        }
	    }

	    return duplicates;
	}

	private static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

	public static void main(String[] args) {

		int[] nums1 = { 3, 2, 3, 4, 2 };

		System.out.println("Duplicate in [3, 2, 3, 4, 2]: " + findDuplicatesTwoPass(nums1).toString()); // Output: 3,2
	}
}

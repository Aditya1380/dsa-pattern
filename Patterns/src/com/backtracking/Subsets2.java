package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		System.out.println("Subsets II: " + subsetsWithDup(nums));
		// Expected Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
	}

	private static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		backtrack(0, nums, new ArrayList<Integer>(), result);
		return result;
	}

	private static void backtrack(int startIndex, int[] nums, List<Integer> currentPath, List<List<Integer>> result) {

		result.add(new ArrayList<Integer>(currentPath));

		for (int i = startIndex; i < nums.length; i++) {
			if (i > startIndex && nums[i] == nums[i - 1]) {
				continue;
			}

			currentPath.add(nums[i]);

			backtrack(i + 1, nums, currentPath, result);
			currentPath.remove(currentPath.size() - 1);

		}
	}
}

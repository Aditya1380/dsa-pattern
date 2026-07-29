package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println("Subsets: " + subsets(nums));
	}

	private static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		backtrack(0, nums, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int startIndex, int[] nums, List<Integer> currentPath, List<List<Integer>> result) {

		result.add(new ArrayList<>(currentPath));

		for (int i = startIndex; i < nums.length; i++) {

			currentPath.add(nums[i]);
			backtrack(i + 1, nums, currentPath, result);
			currentPath.remove(currentPath.size() - 1);

		}
	}

}

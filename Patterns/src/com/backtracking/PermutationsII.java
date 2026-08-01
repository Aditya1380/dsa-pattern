package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		System.out.println("Unique Permutations: " + permuteUnique(nums));
		// Expected Output: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
	}

	private static List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean[] visited = new boolean[nums.length];

		backtrack(nums, new ArrayList<Integer>(), visited, result);

		return result;
	}

	private static void backtrack(int[] nums, List<Integer> currentPath, boolean[] visited,
			List<List<Integer>> result) {
		// Base case
		if (nums.length == currentPath.size()) {
			result.add(new ArrayList<Integer>(currentPath));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}

			if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) {
				continue;
			}

			visited[i] = true;
			currentPath.add(nums[i]);

			backtrack(nums, currentPath, visited, result);

			visited[i] = false;
			currentPath.remove(currentPath.size() - 1);
		}

	}

}

package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println("Permutations: " + permute(nums));
	}

	private static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> results = new ArrayList<List<Integer>>();
		boolean[] visited = new boolean[nums.length];
		backtrack(nums, visited, new ArrayList<>(), results);
		return results;
	}

	private static void backtrack(int[] nums, boolean[] visited, List<Integer> currentPath,
			List<List<Integer>> results) {

		if (currentPath.size() == nums.length) {
			results.add(new ArrayList<>(currentPath));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			currentPath.add(nums[i]);

			backtrack(nums, visited, currentPath, results);

			visited[i] = false;
			currentPath.remove(currentPath.size() - 1);

		}
	}
}

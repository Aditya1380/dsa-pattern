package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		System.out.println("Combination Sum: " + combinationSum(candidates, target));
		// Expected Output: [[2, 2, 3], [7]]
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		backtrack(0, target, candidates, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int startIndex, int remainingTarget, int[] candidates, List<Integer> currentPath,
			List<List<Integer>> result) {

		if (remainingTarget == 0) {
			result.add(new ArrayList<Integer>(currentPath));
			return;
		}

		for (int i = startIndex; i < candidates.length; i++) {

			if (remainingTarget - candidates[i] < 0) {
				break;
			}

			currentPath.add(candidates[i]);

			backtrack(i, remainingTarget - candidates[i], candidates, currentPath, result);

			currentPath.remove(currentPath.size() - 1);
		}

	}
}

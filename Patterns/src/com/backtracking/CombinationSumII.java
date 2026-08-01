package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println("Combination Sum II: " + combinationSum2(candidates, target));
        // Expected Output: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    }

	private static List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Arrays.sort(candidates);
		
		backtrack(0,target,candidates,new ArrayList<Integer>(),result);
		return result;
	}

	private static void backtrack(int startIndex, int remainingTarget, int[] candidates, List<Integer> currentPath,
			List<List<Integer>> result) {

		if(remainingTarget==0) {
			result.add(new ArrayList<Integer>(currentPath));
			return;
		}
		
		for(int i=startIndex;i<candidates.length;i++) {
			if (remainingTarget - candidates[i] < 0) {
                break;
            }
			
			if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
			
			currentPath.add(candidates[i]);
			
			backtrack(i + 1, remainingTarget - candidates[i], candidates, currentPath, result);
			
			currentPath.remove(currentPath.size() - 1);
		}
		
	}
}

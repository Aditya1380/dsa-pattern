package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int startIndex, int n, int k, List<Integer> currentPath, List<List<Integer>> result) {
        // Step 1: Base Case - combination reaches desired size k
        if (currentPath.size() == k) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        // Step 2: Loop from startIndex up to n
        // Optimization: Stop loop early if not enough elements remain to reach size k
//        for (int i = startIndex; i <= n - (k - currentPath.size()) + 1; i++) {
        for (int i = startIndex; i <= n; i++) {
            // STEP A: MAKE CHOICE
            currentPath.add(i);

            // STEP B: RECURSE (move forward to i + 1)
            backtrack(i + 1, n, k, currentPath, result);

            // STEP C: UNDO CHOICE (Backtrack!)
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println("Combinations: " + combine(n, k));
    }
}
package com.treedfs;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public static void main(String[] args) {
        // Constructing our test tree:
        // 5
        // / \
        // 4 8
        // / / \
        // 11 13 4
        // / \ / \
        // 7 2 5 1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> result = pathSum(root, targetSum);

        System.out.println("Paths that sum to 22: " + result);
        // Expected Output: [[5, 4, 11, 2], [5, 8, 4, 5]]
    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();

        List<Integer> currentPath = new ArrayList<>();

        dfs(root, targetSum, currentPath, allPaths);

        return allPaths;
    }

    private static void dfs(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        currentPath.add(root.val);

        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                allPaths.add(new ArrayList<>(currentPath));
            }
        } else {
            dfs(root.left, targetSum - root.val, currentPath, allPaths);
            dfs(root.right, targetSum - root.val, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1);
    }

}

package com.treedfs;

public class PathSumEx4 {
	public static void main(String[] args) {
		// Constructing a sample tree:
		// 5
		// / \
		// 4 8
		// / /
		// 11 13
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);

		int target1 = 20; // Path exists: 5 -> 4 -> 11 (5 + 4 + 11 = 20)
		int target2 = 22; // Path does NOT exist

		System.out.println("Has path summing to 20? " + hasPathSum(root, target1)); // Output: true
		System.out.println("Has path summing to 22? " + hasPathSum(root, target2)); // Output: false
	}

	private static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return targetSum == root.val;
		}

		int remainingSum = targetSum - root.val;

		return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
	}
}

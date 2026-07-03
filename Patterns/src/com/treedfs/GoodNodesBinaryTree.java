package com.treedfs;

public class GoodNodesBinaryTree {
	public static void main(String[] args) {
        // Constructing a sample tree:
        //        3
        //       / \
        //      1   4
        //     /   / \
        //    3   1   5
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println("Total Good Nodes: " + goodNodes(root)); 
        // Expected Output: 4 
        // The good nodes are: [3] (root), [3] (left-left because 3 >= 3), [4], and [5]
    }

	private static int goodNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return dfs(root,root.val);
	}

	private static int dfs(TreeNode node, int maxSoFar) {
		if(node == null) {
			return 0;
		}
		
		int goodCount = 0;
		
		if(node.val >= maxSoFar) {
			goodCount = 1;
			maxSoFar = node.val;
		}
		
		goodCount += dfs(node.left, maxSoFar);
		goodCount += dfs(node.right, maxSoFar);
		
		return goodCount;
	}

}
